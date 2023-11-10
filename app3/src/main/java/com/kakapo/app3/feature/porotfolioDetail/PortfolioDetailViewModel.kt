package com.kakapo.app3.feature.porotfolioDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakapo.app3.feature.constants.NavArgs
import com.kakapo.common.type.asResult
import com.kakapo.common.type.subscribe
import com.kakapo.data.repository.base.PortfolioRepository
import com.kakapo.model.PortfolioDetailItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PortfolioDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val portfolioRepository: PortfolioRepository
) : ViewModel() {

    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(PortfolioDetailUiState())

    init {
        requestPortfolioDetail()
    }

    private fun requestPortfolioDetail() = viewModelScope.launch {
        val label = savedStateHandle.get<String>(NavArgs.LABEL) ?: ""
        val updateDetails = { items: List<PortfolioDetailItem> ->
            _uiState.update { it.copy(detailItems = items) }
        }
        portfolioRepository.requestDetailPortfolio(label).asResult().subscribe(
            onSuccess = updateDetails
        )
    }
}

data class PortfolioDetailUiState(
    val detailItems: List<PortfolioDetailItem> = emptyList()
)