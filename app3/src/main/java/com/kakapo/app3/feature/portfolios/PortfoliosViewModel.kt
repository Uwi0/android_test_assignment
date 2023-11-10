package com.kakapo.app3.feature.portfolios

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakapo.common.type.asResult
import com.kakapo.common.type.subscribe
import com.kakapo.data.repository.base.PortfolioRepository
import com.kakapo.model.PortfolioItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PortfoliosViewModel @Inject constructor(
    private val portfolioRepository: PortfolioRepository
): ViewModel() {

    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(PortfolioUiState())

    init {
        requestPortfolios()
    }

    private fun requestPortfolios() = viewModelScope.launch {
        val updatePortfolios = { items: List<PortfolioItem> ->
            _uiState.update { it.copy(portfolios = items) }
        }
        portfolioRepository.requestPortfolios().asResult().subscribe(onSuccess = updatePortfolios)
    }
}

data class PortfolioUiState(
    val portfolios: List<PortfolioItem> = emptyList()
)