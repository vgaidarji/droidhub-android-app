package com.vgaidarji.droidhub

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.vgaidarji.droidhub.base.ui.findActivity
import com.vgaidarji.droidhub.base.ui.theme.Blue
import com.vgaidarji.droidhub.base.ui.theme.DroidHubTheme
import com.vgaidarji.droidhub.base.ui.theme.SystemBarColors
import com.vgaidarji.droidhub.base.viewmodel.GitHubUserNameUiState
import com.vgaidarji.droidhub.base.viewmodel.GitHubUserNameViewModel
import com.vgaidarji.droidhub.contributions.ContributionsScreen
import com.vgaidarji.droidhub.profile.ProfileScreen
import com.vgaidarji.droidhub.repositories.RepositoriesScreen
import com.vgaidarji.droidhub.splash.SplashScreen
import com.vgaidarji.droidhub.splash.UserNameScreen
import com.vgaidarji.droidhub.base.R as RBase

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object UserName : Screen("user_name")
    data object Repositories : Screen("repositories")
    data object Profile : Screen("profile")
    data object Contributions : Screen("contributions")
    data object MainScreenRoute : Screen("main_navigation_route")
}

data class NavigationItem(
    val screen: Screen,
    @DrawableRes val icon: Int,
    val label: String,
)

@Composable
fun AppNavigation(
    modifier: Modifier,
    navController: NavHostController,
    gitHubUserNameViewModel: GitHubUserNameViewModel,
    onBack: () -> Unit
) {
    val uiState by gitHubUserNameViewModel.uiState.collectAsStateWithLifecycle()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Splash.route,
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(onNavigateToNextScreen = {
                navController.navigate(Screen.UserName.route)
            })
        }
        composable(Screen.UserName.route) {
            UserNameScreen(onNavigateToHomeScreen = {
                navController.navigate(Screen.MainScreenRoute.route)
            })
        }
        mainNavigation(uiState, onBack = onBack)
    }
}

/**
 * Defines navigation nested graph.
 */
private fun NavGraphBuilder.mainNavigation(
    uiState: GitHubUserNameUiState,
    onBack: () -> Unit
) {
    navigation(
        route = Screen.MainScreenRoute.route,
        startDestination = Screen.Repositories.route
    ) {
        composable(Screen.Repositories.route) {
            RepositoriesScreen(gitHubUserName = uiState.userName, onBack = onBack)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(gitHubUserName = uiState.userName, onBack = onBack)
        }
        composable(Screen.Contributions.route) {
            ContributionsScreen(gitHubUserName = uiState.userName, onBack = onBack)
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
    navController: NavHostController = rememberNavController(),
    gitHubUserNameViewModel: GitHubUserNameViewModel = hiltViewModel()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomNavigationItems: List<NavigationItem> = listOf(
        NavigationItem(
            Screen.Repositories,
            RBase.drawable.ic_octicons_repo,
            stringResource(R.string.title_repositories)
        ),
        NavigationItem(
            Screen.Profile,
            RBase.drawable.ic_octicons_person,
            stringResource(R.string.title_profile)
        ),
        NavigationItem(
            Screen.Contributions,
            RBase.drawable.ic_octicons_calendar,
            stringResource(R.string.title_contributions)
        )
    )

    SystemBarColors()

    Scaffold(
        bottomBar = {
            if (shouldShowBottomNavigation(currentDestination)) {
                MainBottomNavigation(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding(),
                    currentDestinationRoute = currentDestination?.route,
                    onNavigationSelected = { screen ->
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    navigationItems = bottomNavigationItems
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        AppNavigation(Modifier.padding(paddingValues), navController, gitHubUserNameViewModel, onBackNavigation())
    }
}

@Composable
private fun shouldShowBottomNavigation(currentDestination: NavDestination?) =
    currentDestination?.route != Screen.Splash.route &&
            currentDestination?.route != Screen.UserName.route

@Composable
fun MainBottomNavigation(
    modifier: Modifier,
    currentDestinationRoute: String?,
    onNavigationSelected: (Screen) -> Unit,
    navigationItems: List<NavigationItem>
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colorScheme.surface,
        contentColor = contentColorFor(MaterialTheme.colorScheme.surface),
    ) {
        navigationItems.forEach { navigationItem ->
            val isSelected = navigationItem.screen.route == currentDestinationRoute
            val itemColor = if (isSelected) Blue else Color.DarkGray
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(navigationItem.icon),
                        null,
                        tint = itemColor
                    )
                },
                label = {
                    Text(
                        text = navigationItem.label,
                        color = itemColor
                    )
                },
                selected = isSelected,
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
                onClick = { onNavigationSelected(navigationItem.screen) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    val bottomBarItems: List<NavigationItem> = listOf(
        NavigationItem(
            Screen.Repositories,
            RBase.drawable.ic_octicons_repo,
            stringResource(R.string.title_repositories)
        ),
        NavigationItem(
            Screen.Profile,
            RBase.drawable.ic_octicons_person,
            stringResource(R.string.title_profile)
        ),
        NavigationItem(
            Screen.Contributions,
            RBase.drawable.ic_octicons_calendar,
            stringResource(R.string.title_contributions)
        )
    )

    DroidHubTheme {
        Scaffold(
            bottomBar = {
                MainBottomNavigation(
                    modifier = Modifier
                        .fillMaxWidth(),
                    currentDestinationRoute = Screen.Repositories.route,
                    onNavigationSelected = {},
                    navigationItems = bottomBarItems
                )
            },
            containerColor = MaterialTheme.colorScheme.background
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues))
        }
    }
}
