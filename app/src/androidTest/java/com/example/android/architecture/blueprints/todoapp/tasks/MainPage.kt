package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers

class MainPage : BaseFun() {
    var TITLE_1: String = "First"
    var TITLE_2: String = "Second"
    var TITLE_3: String = "Third"
    var TITLE_4: String = "Fourth"


    var DESCRIPTION_First: String = "First descrition"
    var DESCRIPTION_Second: String = "Second descrition"
    var DESCRIPTION_Third: String = "Third descrition"
    var DESCRIPTION_Fourth: String = "Fourth descrition"


    open fun createTask(title: String, description: String): MainPage {
        click(add_task_btn)
            .write(title_text_on_new_task_page, title)
            .write(description_task_on_NewTaskPage, description)
            .click(save_task_btn)
        return this
    }

    fun chooseTask(title: String): MainPage {
        click(title)
        Espresso.onView(ViewMatchers.withId(check_box_in_task)).perform(ViewActions.click())
        back()
        return this
    }

    fun selectAllTasks(): MainPage {
        click(filter_menu)
            .clickWithText("All")
            .checkTextIsDisplay("All Tasks")
        return this
    }

    fun selectActiveTasks(): MainPage {
        click(filter_menu)
            .clickWithText("Active")
            .checkTextIsDisplay("Active Tasks")
        return this
    }

    fun clearCompleted(): MainPage {
        createTask("Deleted", "task will be deleted")
            .closeKeyboard()
            .swipeUp()
        chooseTask("Deleted")
            .click(kebab_menu)
            .click("Clear completed")
        return this
    }


    fun selectCompletedTasks(): MainPage {
        createTask("completed", "task will be completed")
            .closeKeyboard()
            .swipeUp()
            .wait(1000)
        chooseTask("completed")
            .wait(1000)
            .click(filter_menu)
            .clickWithText("Completed")
            .checkTextIsDisplay("Completed Tasks")
            .check_Text("completed")
        return this
    }

    fun deleteTask(title: String) {
        swipeUp()
        chooseTask(title)
        click(kebab_menu)
        click("Clear completed")
    }

    fun editTask() {
        clickWithText(Build_tower_in_PisaTask)
            .click(edit_task_btn)
        EditPage().reWrite(title_on_EditTaskPage, "Build tower in Vinnytsia")
            .reWrite(description_on_EditTaskPage, "Ground looks bad, no foundation work required.")
            .click(save_task_btn)
            .wait(500)
            .clickWithText("Build tower in Vinnytsia")
            .checkIsContainsText(
                descriptiob_on_TaskDetailPage,
                "Ground looks bad, no foundation work required."
            )
    }

    fun createAndSaveTaskWithoutTitle() {
        click(add_task_btn)
            .write(title_text_on_new_task_page, "test")
            .checkTexIsNotDisplay("All Tasks")
    }

    fun createAndSaveTaskWithoutDescription() {
        click(add_task_btn)
            .write(description_task_on_NewTaskPage, "test")
            .checkTexIsNotDisplay("All Tasks")
    }

}