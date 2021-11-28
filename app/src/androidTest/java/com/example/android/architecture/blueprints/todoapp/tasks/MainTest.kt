package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(TasksActivity::class.java)
    val mainPage: MainPage = MainPage()
    val editPage: EditPage = EditPage()
    val detailPage: DetailPage = DetailPage()

    @Test
    fun createAndSaveTask() {
        mainPage.createTask("createAndSaveTask", "create    AndSave      Task")
    }

    @Test
    fun deleteTaskOnDetailPage() {
        mainPage.createTask("Delete", "task will be delete")
            .swipeUp()
            .click("Delete")
        detailPage.deleteTask()
            .checkTexIsNotDisplay("Delete task")
    }

    @Test
    fun deleteTaskOnMainPage() {
        mainPage.createTask("Deleted", "task will be deleted")
        swipeUp()
        mainPage.deleteTask("Deleted")
    }

    @Test
    fun openAndCheckTaskDescription() {
        mainPage.createTask("openAndCheckTaskDescription", "Description")
        BaseFun().swipeUp()
        detailPage.checkDescription("openAndCheckTaskDescription", "Description")
    }

    @Test
    fun createFourTasks() {
        mainPage.createTask(mainPage.TITLE_1, mainPage.DESCRIPTION_First)
            .createTask(mainPage.TITLE_2, mainPage.DESCRIPTION_Second)
            .createTask(mainPage.TITLE_3, mainPage.DESCRIPTION_Third)
            .createTask(mainPage.TITLE_4, mainPage.DESCRIPTION_Fourth)
    }

    @Test
    fun filterTaskAll() {
        mainPage.selectAllTasks()
    }

    @Test
    fun filterTaskActive() {
        mainPage.selectActiveTasks()
    }

    @Test
    fun filterTaskCompleted() {
        BaseFun().swipeUp()
        mainPage.selectCompletedTasks()
    }

    @Test
    fun editTask() {
        mainPage.editTask()
    }

    @Test
    fun createTaskWithoutTitle() {
        mainPage.createAndSaveTaskWithoutTitle()
    }

    @Test
    fun createTaskWithoutDescriptin() {
        mainPage.createAndSaveTaskWithoutDescription()
    }

}