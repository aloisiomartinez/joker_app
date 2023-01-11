package com.aloisiomartinez.joker_app.data

interface ListCategoryCallback {
    fun onSuccess(response: List<String>)
    fun onError(response: String)
    fun onComplete()
}