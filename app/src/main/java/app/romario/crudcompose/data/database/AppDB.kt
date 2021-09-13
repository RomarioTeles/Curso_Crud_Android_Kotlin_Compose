package app.romario.crudcompose.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import app.romario.crudcompose.data.dao.CidadesDAO
import app.romario.crudcompose.data.entities.Cidades

@Database(
    entities = [Cidades::class],
    version = 1,
    exportSchema = false
)
abstract class AppDB : RoomDatabase() {
 abstract fun cidadesDAO() : CidadesDAO
}