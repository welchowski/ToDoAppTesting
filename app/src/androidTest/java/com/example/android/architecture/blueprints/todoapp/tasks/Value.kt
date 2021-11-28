package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.android.architecture.blueprints.todoapp.R

open class Value {

    //MAIN PAGE
    var add_task_btn: Int = R.id.add_task_fab
    var clear_sub_menu: Int = R.id.menu_clear
    var check_box: Int = R.id.complete_checkbox
    var all: Int = R.id.all
    var active: Int = R.id.active
    var completed: Int = R.id.completed
    var kebab_menu: ViewInteraction = onView(ViewMatchers.withContentDescription("More options"))
    var filter_menu: Int = R.id.menu_filter
    var hamburger_menu: ViewInteraction =
        onView(ViewMatchers.withContentDescription("Open navigation drawer"))
    var title_text_on_main_page: Int = R.id.title_text
    var filtering_text: Int = R.id.filtering_text
    var statistics: Int = R.id.design_menu_item_text
    var stats_active_tasks: Int = R.id.stats_active_text
    var stats_completed_tasks: Int = R.id.stats_completed_text


    //EDIT PAGE
    var title_on_EditTaskPage: Int = R.id.add_task_title_edit_text
    var edit_task_btn: Int = R.id.edit_task_fab
    var description_on_EditTaskPage: Int = R.id.add_task_description_edit_text

    //DETAIL PAGE
    var description_task: Int = R.id.task_detail_title_text
    var title_on_TaskDetailPage: Int = R.id.task_detail_title_text
    var basket_btn: Int = R.id.menu_delete
    var descriptiob_on_TaskDetailPage: Int = R.id.task_detail_description_text

    //NEW TASK PAGE
    var check_box_in_task: Int = R.id.task_detail_complete_checkbox
    var save_task_btn: Int = R.id.save_task_fab
    var description_task_on_NewTaskPage: Int = R.id.add_task_description_edit_text
    var title_text_on_new_task_page: Int = R.id.add_task_title_edit_text


    var Build_tower_in_PisaTask: String = "Build tower in Pisa"
    var DESCRIPTIONSofBuild_tower_in_Pisa: String =
        "Ground looks good, no foundation work required."

}