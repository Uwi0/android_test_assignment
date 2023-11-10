package com.kakapo.app3.feature.porotfolioDetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kakapo.app3.feature.constants.NavArgs
import com.kakapo.app3.feature.porotfolioDetail.PortfolioDetailRoute
import com.kakapo.common.type.Func

const val PORTFOLIO_DETAIL_ROUTE = "portfolio_detail_route"

fun NavController.navigateToPortfolioDetailRoute(label: String, navOptions: NavOptions? = null) {
    navigate("$PORTFOLIO_DETAIL_ROUTE/$label", navOptions)
}

fun NavGraphBuilder.portfolioDetailScreen(onNavBack: Func) {
    val arguments = listOf(navArgument(name = NavArgs.LABEL) { type = NavType.StringType })
    composable("$PORTFOLIO_DETAIL_ROUTE/{${NavArgs.LABEL}}", arguments) {
        PortfolioDetailRoute(onNavBack = onNavBack)
    }
}