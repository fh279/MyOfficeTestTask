package com.geekbrains.tests.pageObjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.geekbrains.tests.R
import org.hamcrest.CoreMatchers.not


class FoundElement {

    private val totalCountText: ViewInteraction
        get() = onView(
            withId(R.id.totalCountTextView))

    private val arrayOfResults: ViewInteraction
        get() = onView(
            withId(R.id.recyclerView))

    private val text : ViewInteraction
        get() = onView(withId(R.id.repositoryName))

    private val checkbox: ViewInteraction
        get() = onView(withId(R.id.checkbox))

    fun setCheckbox(isSet: Boolean){
        if (isSet){
            checkbox.check(matches(isNotChecked())).perform(click())
            }
        else {
            checkbox.check(matches(isChecked())).perform(click())
        }
    }

    fun checkResultsIsPresent(text : String){
        totalCountText.check(matches(withText("Number of results:")))
    }

    fun checkResultIsntEmpty(text: String, count: Int){
        arrayOfResults.check(matches(not(hasChildCount(count))))
    }


}