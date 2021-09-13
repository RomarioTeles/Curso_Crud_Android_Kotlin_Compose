package app.romario.crudcompose.data.repositories

import app.romario.crudcompose.data.dao.CidadesDAO
import app.romario.crudcompose.data.database.AppDB
import app.romario.crudcompose.data.entities.Cidades
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class CidadesRepository @Inject constructor(appDB: AppDB){

    private val dao = appDB.cidadesDAO()


    suspend fun insert(cidades: Cidades) {
        dao.insert(cidades)
    }

    suspend fun update(cidades: Cidades) {
        dao.update(cidades)
    }

    suspend fun delete(cidades: Cidades) {
        dao.delete(cidades)
    }

    fun getAllCidades(): Flow<List<Cidades>> {
       return dao.getAllCidades()
    }

}