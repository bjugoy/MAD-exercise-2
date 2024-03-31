import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.screens.DetailScreen


object Destinations {
    const val HOME_SCREEN = "homescreen"
    const val DETAIL_SCREEN = "detailscreen"
}


@Composable
fun Navigation(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destinations.HOME_SCREEN
    ) {
        composable(route = Destinations.HOME_SCREEN) {
            HomeScreen(navController = navController)
        }

        composable(
            route = "${Destinations.DETAIL_SCREEN}/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId") ?: ""
            DetailScreen(movieId = movieId)
        }
    }
}
