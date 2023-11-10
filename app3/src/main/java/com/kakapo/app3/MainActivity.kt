package com.kakapo.app3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.kakapo.app3.feature.porotfolioDetail.navigation.navigateToPortfolioDetailRoute
import com.kakapo.app3.feature.porotfolioDetail.navigation.portfolioDetailScreen
import com.kakapo.app3.feature.portfolios.PortfoliosRoute
import com.kakapo.app3.feature.portfolios.navigation.PORTFOLIOS_ROUTE
import com.kakapo.app3.feature.portfolios.navigation.portfolioScreen
import com.kakapo.designsystem.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppTheme {
                NavHost(navController = navController, startDestination = PORTFOLIOS_ROUTE){
                    portfolioScreen(onItemClick = navController::navigateToPortfolioDetailRoute)
                    portfolioDetailScreen(onNavBack = navController::popBackStack)
                }
            }
        }
    }
}

