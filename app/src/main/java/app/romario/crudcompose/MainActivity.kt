package app.romario.crudcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.romario.crudcompose.data.entities.Cidades
import app.romario.crudcompose.telaalteracao.TelaDetalhesScreen
import app.romario.crudcompose.telacadastro.TelaCadastrarScreen
import app.romario.crudcompose.telalistagem.TelaListagemScreen
import app.romario.crudcompose.ui.theme.CrudcomposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrudcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "TelaInicial" ){
                        composable("TelaInicial"){
                            TelaInicial(navController)
                        }
                        composable("TelaCadastrar"){
                            TelaCadastrarScreen(navController = navController)
                        }
                        composable("TelaDetalhes"){
                            val cidade = navController.previousBackStackEntry!!.arguments!!.getParcelable<Cidades>("cidade")
                            cidade?.let{
                                TelaDetalhesScreen(navController = navController, cidade = it)
                            }


                        }
                    }

                }
            }
        }
    }
}

@Composable
fun TelaInicial(navHostController: NavHostController) {
    Scaffold(
        content= {
            Column {
                TelaListagemScreen(navController = navHostController)
            }
        },
        topBar = {
            TopAppBar(title = { Text(text = "App CRUD") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate("TelaCadastrar")
            })
            {
                Icon(Icons.Filled.Add, contentDescription = "")
            }
        }
    )
        

}

