package com.geekbrains.tests.pageObjects
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.geekbrains.tests.R

class MainPage {

    private val toDetailsButton: ViewInteraction
        get() = onView(withId(R.id.toDetailsActivityButton))

    private val searchInputField: ViewInteraction
        get() = onView(withId(R.id.searchEditText))

    private val numberOfResultsText: ViewInteraction
        get() = onView(withId(R.id.totalCountTextView))



    fun checkToDetailsButtonVisibility(){   // этому не тут место    делай класс MainPageSteps
        toDetailsButton.check(matches(isDisplayed()))
    }

    fun checkSearchInputFielsVisibility(){   // этому не тут место     делай класс MainPageSteps
        searchInputField.check(matches(isDisplayed()))
    }

    fun tapToSearch(){
        searchInputField.perform(pressImeActionButton())
    }

    fun fillInputField(stringData: String){
        searchInputField.check(matches(isDisplayed())).perform(typeText(stringData))
    }

    fun clearInputField(){
        searchInputField.perform(clearText())
    }

    fun tapToDetailsButton(){
        toDetailsButton.perform(click())
    }

    /*fun checkResultsIsPresent(testText: String){
    это не тут, это в экране найденного
    }*/

/* fun findElement(){
        onView(withId(R.id.te))
    }*/








}