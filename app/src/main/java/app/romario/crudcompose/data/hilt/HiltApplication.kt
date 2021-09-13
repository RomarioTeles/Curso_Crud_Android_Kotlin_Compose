package app.romario.crudcompose.data.hilt

import android.app.Application
import android.content.Context
import androidx.room.Room
import app.romario.crudcompose.data.database.AppDB
import app.romario.crudcompose.data.entities.Cidades
import app.romario.crudcompose.data.repositories.CidadesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@HiltAndroidApp
class HiltApplication : Application()

@Module
@InstallIn(SingletonComponent::class)
object DbModule{

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDB
    {
        return Room.databaseBuilder(context, AppDB::class.java, "appdb.db").fallbackToDestructiveMigration().build()
    }

    @Provides
    fun CidadesRepository(db: AppDB) = db.cidadesDAO()
}