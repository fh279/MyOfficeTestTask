package com.geekbrains.tests.pageObjects

import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.geekbrains.tests.R

class DetailsPage {

    // Тут описано самое базовое, здесь еще нужно реализовать возможность мониторить изменение
    // количества найденных элементов. Для этого нужно перехватить данные из SearchPresenter.kt
    // (не успел додумать)

    val decrementButton: ViewInteraction
        get() = onView(withId(R.id.decrementButton))

    val incrementButton: ViewInteraction
        get() = onView(withId(R.id.incrementButton))

    val totalCountText: ViewInteraction
        get() = onView(withId(R.id.totalCountTextView))

    fun checkDecrementButton(){
        decrementButton.check(matches(isDisplayed()))
    }

    fun checkIncrementButton(){
        incrementButton.check(matches(isDisplayed()))
    }
}