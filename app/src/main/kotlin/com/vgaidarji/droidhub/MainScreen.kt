package com.vgaidarji.droidhub

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.contentColorFor
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.vgaidarji.droidhub.base.ui.findActivity
import com.vgaidarji.droidhub.base.ui.theme.SystemBarColors
import com.vgaidarji.droidhub.contributions.ContributionsScreen
import com.vgaidarji.droidhub.profile.ProfileScreen
import com.vgaidarji.droidhub.repositories.RepositoriesScreen
import com.vgaidarji.droidhub.splash.SplashScreen
import com.vgaidarji.droidhub.base.R as RBase

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Repositories : Screen("repositories")
    data object Profile : Screen("profile")
    data object Contributions : Screen("contributions")
    data object MainScreenRoute : Screen("main_navigation_route")
}

@Composable
fun AppNavigation(
    modifier: Modifier,
    navController: NavHostController,
    onBack: () -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Splash.route,
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(onNavigateToHomeScreen = {
                navController.navigate(Screen.MainScreenRoute.route)
            })
        }
        mainNavigation(onBack = onBack)
    }
}

/**
 * Defines navigation nested graph.
 */
private fun NavGraphBuilder.mainNavigation(onBack: () -> Unit) {
    navigation(
        route = Screen.MainScreenRoute.route,
        startDestination = Screen.Repositories.route
    ) {
        composable(Screen.Repositories.route) {
            RepositoriesScreen(onBack = onBack)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(onBack = onBack)
        }
        composable(Screen.Contributions.route) {
            ContributionsScreen(onBack = onBack)
        }
    }
}

@Composable
private fun onBackNavigation(): () -> Unit {
    val context = LocalContext.current
    return {
        context.findActivity()?.finish()
    }
}

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    SystemBarColors()

    Scaffold(
        bottomBar = {
            MainBottomNavigation(
                modifier = Modifier.fillMaxWidth().navigationBarsPadding(),
                currentDestination = currentDestination,
                onNavigationSelected = { screen ->
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        AppNavigation(Modifier.padding(paddingValues), navController, onBackNavigation())
    }
}

@Composable
fun MainBottomNavigation(
    modifier: Modifier,
    currentDestination: NavDestination?,
    onNavigationSelected: (Screen) -> Unit
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colorScheme.surface,
        contentColor = contentColorFor(MaterialTheme.colorScheme.surface),
    ) {
        BottomNavigationItem(
            icon = { Icon(painterResource(RBase.drawable.ic_octicons_repo), null) },
            label = { Text(stringResource(id = R.string.title_repositories)) },
            selected = currentDestination?.hierarchy?.any { it.route == Screen.Repositories.route } == true,
            onClick = { onNavigationSelected(Screen.Repositories) },
            selectedContentColor = MaterialTheme.colorScheme.primary,
            unselectedContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
        )

        BottomNavigationItem(
            icon = { Icon(painterResource(RBase.drawable.ic_octicons_person), null) },
            label = { Text(stringResource(id = R.string.title_profile)) },
            selected = currentDestination?.hierarchy?.any { it.route == Screen.Profile.route } == true,
            onClick = { onNavigationSelected(Screen.Profile) },
            selectedContentColor = MaterialTheme.colorScheme.primary,
            unselectedContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
        )

        BottomNavigationItem(
            icon = { Icon(painterResource(RBase.drawable.ic_octicons_calendar), null) },
            label = { Text(stringResource(id = R.string.title_contributions)) },
            selected = currentDestination?.hierarchy?.any { it.route == Screen.Contributions.route } == true,
            onClick = { onNavigationSelected(Screen.Contributions) },
            selectedContentColor = MaterialTheme.colorScheme.primary,
            unselectedContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
        )
    }
}