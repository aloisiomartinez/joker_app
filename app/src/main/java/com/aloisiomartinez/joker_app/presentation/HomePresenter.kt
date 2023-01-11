package com.aloisiomartinez.joker_app.presentation

import android.os.Handler
import android.os.Looper
import com.aloisiomartinez.joker_app.data.CategoryRemoteDataSource
import com.aloisiomartinez.joker_app.data.ListCategoryCallback
import com.aloisiomartinez.joker_app.model.Category
import com.aloisiomartinez.joker_app.view.CategoryItem
import com.aloisiomartinez.joker_app.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    fun finAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onSuccess(response: List<String>) {
        val categories = response.map { category -> Category(category, 0xFFFF00000) }
        view.showCategories(categories)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }


}