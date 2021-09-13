package app.romario.crudcompose.data.dao

import androidx.room.*
import app.romario.crudcompose.data.entities.Cidades
import kotlinx.coroutines.flow.Flow

@Dao
interface CidadesDAO {

    @Insert
    suspend fun insert(cidades: Cidades)

    @Update
    suspend fun update(cidades: Cidades)

    @Delete
    suspend fun delete(cidades: Cidades)

    @Query("""
        SELECT c.* FROM cidades c Order BY c.nome_cidade
    """)
    fun getAllCidades() : Flow<List<Cidades>>
}