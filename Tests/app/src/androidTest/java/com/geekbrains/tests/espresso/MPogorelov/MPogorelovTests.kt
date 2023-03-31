package com.geekbrains.tests.espresso.MPogorelov

import androidx.test.core.app.ActivityScenario
import com.geekbrains.tests.pageObjects.DetailsPage
import com.geekbrains.tests.pageObjects.FoundElement
import com.geekbrains.tests.pageObjects.MainPage
import com.geekbrains.tests.view.details.DetailsActivity
import com.geekbrains.tests.view.search.MainActivity

import org.junit.After
import org.junit.Before
import org.junit.Test

class MPogorelovTests {

    private lateinit var scenario: ActivityScenario<MainActivity>

    val mainPage = MainPage()
    val detailsPage = DetailsPage()
    val foundElement = FoundElement()   // Не успел написать тест под экран где есть найденные элементы,
                                        // но PageObject под него оформлен.

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun close() {
        scenario.close()
    }

    @Test
    fun positiveFlowTest(){
        /*Неболшой тест, демонстрирующий позитивный сценарий использования приложения.
        Сюда в конец так же нужно было бы добавить кейс "при изменении кол-ва результатов на главном
        экране, значение кол-ва результатов изменяется и на странице Details.
        Так же видится интересным проверка того что чекбокс результатов может "вылезать" за границу экрана.
        (проверял, такой кейс реален)*/
        mainPage.checkSearchInputFielsVisibility()
        mainPage.checkToDetailsButtonVisibility()
        mainPage.fillInputField("repo")
        mainPage.tapToSearch()
        mainPage.tapToDetailsButton()
        detailsPage.checkDecrementButton()
        detailsPage.checkIncrementButton()
    }

    @Test
    fun isolateTestWithDetailsScreen(){
        /* тут довольно топорно: из-за наличия аннотации @Before, главная активность все таки
        запускается. После этого происходит запуск активности страницы Details(как требует условие задания).
        Сюда же нужно дописать возможность прокидывать данные из SearchPresenter.kt
        (вижу через дебаггер нужные мне данные (количество и состав найденных результатов) ),
        не успел доделать. Нужно поразбираться. */
        ActivityScenario.launch(DetailsActivity::class.java)
        detailsPage.checkIncrementButton()  // совсем базовая проверка наличия элементов.
        detailsPage.checkDecrementButton()
        //ActivityScenario.launch(DetailsActivity::class.java).close()
    }
}