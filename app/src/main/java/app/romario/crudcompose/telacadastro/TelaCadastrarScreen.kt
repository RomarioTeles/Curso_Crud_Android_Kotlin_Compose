package app.romario.crudcompose.telacadastro

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun TelaCadastrarScreen(viewModel: TelaCadastroViewModel = hiltViewModel(), navController: NavController) {
    
    val nome = viewModel.nomeCidade.value
    val cep = viewModel.cepCidade.value
    val uf = viewModel.ufCidade.value
    val status = viewModel.status.observeAsState()

    if(status.value == true){
        navController.popBackStack()
    }
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){

        OutlinedTextField(label= {Text(text="Informe o nome da cidade")} , value = nome, onValueChange = {
            viewModel.onChangeNomeCidade(it)
        })

        Spacer(modifier = Modifier.padding(10.dp))

        OutlinedTextField(label= {Text(text="Informe o CEP da cidade")} , value = cep, onValueChange = {
            viewModel.onChangeCepCidade(it)
        })

        Spacer(modifier = Modifier.padding(10.dp))

        OutlinedTextField(label= {Text(text="Informe o UF da cidade")} , value = uf, onValueChange = {
            viewModel.onChangeuUfCidade(it)
        })

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {viewModel.cadastrar()}) {
            Text(text = "Cadastrar")
        }

    }
    
}

