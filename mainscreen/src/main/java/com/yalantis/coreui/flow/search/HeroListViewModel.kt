package com.yalantis.coreui.flow.search

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.yalantis.coreui.base.BaseViewModel

class HeroListViewModel : BaseViewModel() {

    val adapter = ObservableField<SearchAdapter>()

    //todo add pagination
    val isLoading = ObservableBoolean()
    val isEmpty = ObservableBoolean()

    fun onSearchClicked(searchText: String): Boolean {
        showKeyboard.set(false)
        //todo search
        return true
    }

}