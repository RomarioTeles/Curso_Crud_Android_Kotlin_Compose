package app.romario.crudcompose.telaalteracao

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.romario.crudcompose.data.entities.Cidades

@Composable
fun TelaDetalhesScreen(viewModel: TelaDetalhesViewModel = hiltViewModel(), navController: NavController, cidade: Cidades){

    val nome : String by viewModel.nomeCidade.observeAsState(cidade.nome_cidade.toString())
    val cep : String by viewModel.cepCidade.observeAsState(cidade.cep_cidade.toString())
    val uf : String by viewModel.ufCidade.observeAsState(cidade.uf_cidade.toString())
    val status = viewModel.status.observeAsState()
    viewModel.id = cidade.id!!.toInt()

    viewModel.onChangeNomeCidade(nome)
    viewModel.onChangeCepCidade(cep)
    viewModel.onChangeuUfCidade(uf)

    if(status.value == true){
        navController.popBackStack()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){

        OutlinedTextField(label= { Text(text="Informe o nome da cidade") } , value = nome, onValueChange = {
            viewModel.onChangeNomeCidade(it)
        })

        Spacer(modifier = Modifier.padding(10.dp))

        OutlinedTextField(label= { Text(text="Informe o CEP da cidade") } , value = cep, onValueChange = {
            viewModel.onChangeCepCidade(it)
        })

        Spacer(modifier = Modifier.padding(10.dp))

        OutlinedTextField(label= { Text(text="Informe o UF da cidade") } , value = uf, onValueChange = {
            viewModel.onChangeuUfCidade(it)
        })

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {viewModel.alterar()}) {
            Text(text = "Alterar")
        }


        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {viewModel.remover()}) {
            Text(text = "Remover")
        }

    }



}