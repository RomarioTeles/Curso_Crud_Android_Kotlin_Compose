package app.romario.crudcompose.telaalteracao


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
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
class TelaDetalhesViewModel @Inject constructor(private val dao: CidadesRepository): ViewModel(){

    var id by mutableStateOf<Int>(0)

    private var _nomeCidade = MutableLiveData<String>()
    val nomeCidade: LiveData<String> = _nomeCidade

    private var _cepCidade = MutableLiveData<String>()
    val cepCidade: LiveData<String> = _cepCidade

    private var _ufCidade = MutableLiveData<String>()
    val ufCidade: LiveData<String> = _ufCidade

    val status : MutableLiveData<Boolean> = MutableLiveData()

    fun alterar(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val cidade = Cidades(
                    id,
                    nome_cidade = nomeCidade.value,
                    cep_cidade = cepCidade.value,
                    uf_cidade = ufCidade.value)

                dao.update(cidade)

                withContext(Dispatchers.Main){
                    status.value = true
                }

            }
        }
    }

    fun remover(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val cidade = Cidades(
                    id,
                    nome_cidade = nomeCidade.value,
                    cep_cidade = cepCidade.value,
                    uf_cidade = ufCidade.value)

                dao.delete(cidade)

                withContext(Dispatchers.Main){
                    status.value = true
                }
            }
        }
    }

    fun onChangeNomeCidade(newValue: String){
        _nomeCidade.value = newValue
    }

    fun onChangeCepCidade(newValue: String){
        _cepCidade.value = newValue
    }

    fun onChangeuUfCidade(newValue: String){
        _ufCidade.value = newValue
    }
}