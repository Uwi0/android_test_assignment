package com.kakapo.app3.feature.portfolios.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kakapo.app3.feature.portfolios.PortfoliosRoute
import com.kakapo.common.type.Fun

const val PORTFOLIOS_ROUTE = "portfolios_route"

fun NavGraphBuilder.portfolioScreen(onItemClick: Fun<String, Unit>){
    composable(PORTFOLIOS_ROUTE){
        PortfoliosRoute(onItemClick = onItemClick)
    }
}