package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers

class EditPage : BaseFun() {
    fun reWrite(id: Int, titile: String): EditPage {
        Espresso.onView(ViewMatchers.withId(id)).perform(ViewActions.replaceText(titile));
        return this
    }
}