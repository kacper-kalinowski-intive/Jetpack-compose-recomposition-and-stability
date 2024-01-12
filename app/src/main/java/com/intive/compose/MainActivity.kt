package com.intive.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.intive.compose.ui.Home
import com.intive.compose.ui.navigation.Destinations
import com.intive.compose.ui.phases.Composition
import com.intive.compose.ui.phases.Draw
import com.intive.compose.ui.phases.Layout
import com.intive.compose.ui.recomposition.base.MainBaseComponent
import com.intive.compose.ui.recomposition.lambdascope.MainLambdaComponent
import com.intive.compose.ui.recomposition.lambdascopeclosure.MainLambdaClosureComponent
import com.intive.compose.ui.recomposition.lambdascopeexpanded.MainLambdaExpandedComponent
import com.intive.compose.ui.recomposition.nonrestartable.MainNonRestartableComponent
import com.intive.compose.ui.recomposition.unstablelambda.MainUnstableLambdaComponent
import com.intive.compose.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    navBackStackEntry?.destination?.route?.uppercase()?.let {
                        Text(text = it)
                    }
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        NavHost(
                            navController = navController,
                            startDestination = Destinations.HOME_ROUTE,
                        ) {
                            composable(Destinations.HOME_ROUTE) {
                                Home(
                                    navigateTo = { navController.navigate(it) }
                                )
                            }
                            composable(Destinations.BASE_ROUTE) {
                                MainBaseComponent()
                            }
                            composable(Destinations.NON_RESTARTABLE_ROUTE) {
                                MainNonRestartableComponent()
                            }
                            composable(Destinations.LAMBDA_ROUTE) {
                                MainLambdaComponent()
                            }
                            composable(Destinations.LAMBDA_EXPANDED_ROUTE) {
                                MainLambdaExpandedComponent()
                            }
                            composable(Destinations.LAMBDA_CLOSURE_ROUTE) {
                                MainLambdaClosureComponent()
                            }
                            composable(Destinations.UNSTABLE_LAMBDA_ROUTE) {
                                MainUnstableLambdaComponent()
                            }
                            composable(Destinations.COMPOSITION_ROUTE) {
                                Composition()
                            }
                            composable(Destinations.LAYOUT_ROUTE) {
                                Layout()
                            }
                            composable(Destinations.DRAW_ROUTE) {
                                Draw()
                            }
                        }
                    }
                }
            }
        }
    }
}
