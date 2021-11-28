package com.example.android.architecture.blueprints.todoapp.tasks


import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.*
import androidx.test.espresso.NoMatchingViewException


open class BaseFun : Value() {

    fun baseFun() {}

    open fun click(id: Int): BaseFun {
        onView(withId(id)).perform(click())
        return this
    }

    open fun click(text: String): BaseFun {
        onView(withText(text)).perform(click())
        return this
    }

    open fun click(id: ViewInteraction): BaseFun {
        id.perform(click())
        return this
    }

    open fun swipeUp(): BaseFun {
        closeKeyboard()
        onView(withId(android.R.id.content)).perform(ViewActions.swipeUp());
        return this
    }

    open fun clickWithText(text: String): BaseFun {
        onView(
            withText(text)
        ).perform(click())
        return this
    }

    fun check_Text(id: Int, str: String): BaseFun {
        onView(withId(id)).check(matches(withText(str))).perform(click());
        return this
    }

    fun check_Text(text: String): BaseFun {
        onView(withText(text)).check(matches(withText(text)))
        return this
    }

    fun checkTextIsDisplay(text: String): BaseFun {
        onView(withText(text)).check(matches(isDisplayed()))
        return this
    }

    fun checkTexIsNotDisplay(text: String): BaseFun {
        onView(withText(text)).check((doesNotExist()))
        return this
    }

    fun back(): BaseFun {
        closeKeyboard()
        Espresso.pressBack()
        return this
    }

    fun closeKeyboard(): BaseFun {
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard())
        return this
    }


    fun write(id: Int, titile: String): BaseFun {
        onView(withId(id)).perform(typeText(titile))
        return this
    }


    fun checkIsContainsText(id: Int, titile: String): BaseFun {
        onView(withId(id)).check(matches(withText(containsString(titile))))
        return this
    }

    fun chooseIfNotChoosen(title: String): BaseFun {
        click(title)
        try {
            onView(withText(check_box_in_task)).perform(click())
        } catch (ignore: NoMatchingViewException) {
        }
        return this
    }

    fun check_snackbar_view(): BaseFun {
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText("Task added")))
        return this
    }

    fun checkIsContainsElement(id: Int, str: String): BaseFun {
        onView(withId(id)).check(matches(withText(str)))
        return this
    }

    fun wait(mls: Long): BaseFun {
        Thread.sleep(mls)
        return this
    }


}