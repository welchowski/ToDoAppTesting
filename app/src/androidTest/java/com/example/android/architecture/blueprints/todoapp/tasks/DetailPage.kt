package com.example.android.architecture.blueprints.todoapp.tasks

class DetailPage : BaseFun() {

    fun deleteTask(): DetailPage {
        click(basket_btn)
        return this
    }

    fun checkDescription(titile: String, description: String) {
        clickWithText(titile)
        check_Text(titile)
        check_Text(description)
    }

}