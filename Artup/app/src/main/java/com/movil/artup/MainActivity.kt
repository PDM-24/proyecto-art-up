import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.movil.artup.screens.ArtworkDetailScreen // Importa ArtworkDetailScreen aquí
import com.movil.artup.screens.EditProfileScreen
import com.movil.artup.screens.ExhibicionScreen
import com.movil.artup.screens.FilteredExhibicionScreen
import com.movil.artup.screens.ProfileScreen
import com.movil.artup.screens.SearchScreen

@ExperimentalMaterial3Api
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "perfil"
    ) {
        composable("perfil") {
            ProfileScreen(navController)
        }
        composable("exhibicion") {
            ExhibicionScreen(navController)
        }
        composable("editarperfil") {
            EditProfileScreen(navController)
        }
        composable(
            "filteredExhibicion/{filterType}",
            arguments = listOf(navArgument("filterType") { type = NavType.StringType })
        ) { backStackEntry ->
            val filterType = backStackEntry.arguments?.getString("filterType") ?: "unknown"
            FilteredExhibicionScreen(navController, filterType)
        }
        composable( // Agrega una nueva ruta para ArtworkDetailScreen
            "artworkDetail/{artworkId}",
            arguments = listOf(navArgument("artworkId") { type = NavType.IntType })
        ) { backStackEntry ->
            val artworkId = backStackEntry.arguments?.getInt("artworkId") ?: -1
            ArtworkDetailScreen(navController, artworkId)
        }
        composable("search") {
            SearchScreen(navController)
    }
}}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun Appp() {
    MyApp()
}
