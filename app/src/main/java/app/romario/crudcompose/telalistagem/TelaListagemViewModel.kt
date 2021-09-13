package app.romario.crudcompose.telalistagem

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import app.romario.crudcompose.data.dao.CidadesDAO
import app.romario.crudcompose.data.entities.Cidades
import app.romario.crudcompose.data.repositories.CidadesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TelaListagemViewModel @Inject constructor(private val dao: CidadesRepository) : ViewModel(){

    val cidadesLista : LiveData<List<Cidades>> = dao.getAllCidades().asLiveData()



}