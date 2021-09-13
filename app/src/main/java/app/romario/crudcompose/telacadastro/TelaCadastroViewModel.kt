package app.romario.crudcompose.telacadastro

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.romario.crudcompose.data.entities.Cidades
import app.romario.crudcompose.data.repositories.CidadesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TelaCadastroViewModel @Inject constructor(private val dao: CidadesRepository): ViewModel(){

    val nomeCidade = mutableStateOf("")

    val cepCidade = mutableStateOf("")

    val ufCidade = mutableStateOf("")

    val status : MutableLiveData<Boolean> = MutableLiveData()

    fun cadastrar(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val cidade = Cidades(
                    nome_cidade = nomeCidade.value,
                    cep_cidade = cepCidade.value,
                    uf_cidade = ufCidade.value)

                dao.insert(cidade)
                withContext(Dispatchers.Main){
                    status.value = true
                }
            }
        }
    }

    fun onChangeNomeCidade(newValue: String){
        nomeCidade.value = newValue
    }

    fun onChangeCepCidade(newValue: String){
        cepCidade.value = newValue
    }

    fun onChangeuUfCidade(newValue: String){
        ufCidade.value = newValue
    }
}