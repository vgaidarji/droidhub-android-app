package com.vgaidarji.droidhub

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vgaidarji.droidhub.contributions.ContributionsScreen
import com.vgaidarji.droidhub.profile.ProfileScreen
import com.vgaidarji.droidhub.repositories.RepositoriesScreen
import com.vgaidarji.droidhub.splash.SplashScreen

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Repositories : Screen("repositories")
    data object Profile : Screen("profile")
    data object Contributions : Screen("contributions")
}

@Composable
fun AppNavigation(
    modifier: Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Splash.route,
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(onNavigateToHomeScreen = {
                navController.navigate(Screen.Repositories.route) {
                    launchSingleTop = true
                    restoreState = true
                }
            })
        }
        composable(Screen.Repositories.route) {
            RepositoriesScreen()
        }
        composable(Screen.Profile.route) {
            ProfileScreen()
        }
        composable(Screen.Contributions.route) {
            ContributionsScreen()
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(modifier, color = MaterialTheme.colorScheme.background) {
        AppNavigation(modifier = modifier, navController = navController)
    }
}