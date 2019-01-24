package com.yalantis.coreui.flow.search

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.yalantis.core.usecases.SearchByNameUsecase
import com.yalantis.coreui.base.BaseViewModel

class HeroListViewModel(private val searchByNameUsecase: SearchByNameUsecase) : BaseViewModel() {

    val adapter = ObservableField<SearchAdapter>()

    //todo add pagination
    val isLoading = ObservableBoolean()
    val isEmpty = ObservableBoolean()

    fun onSearchClicked(searchText: String): Boolean {
        showKeyboard.set(false)
        searchByNameUsecase.searchByName(searchText)
        return true
    }

}