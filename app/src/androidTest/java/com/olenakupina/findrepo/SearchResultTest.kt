package com.olenakupina.findrepo

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.olenakupina.findrepo.Screens.SearchScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchResultTest(){

    @Rule
    fun activityRule(): ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java, false, true)

    @Test
    fun matchesLink(){
        val searchScreen = SearchScreen()
        val searchResultScreen = SearchScreen().tapOnSearchButton()
        val repo = "JetBrains/kotlin"
        val gitHubScreen = searchResultScreen.tapOnARepoInSearchList(repo)

        val textSearchForRepo = "Kotlin"

        searchScreen.typeTextInSearchForReposField(textSearchForRepo)
        searchScreen.tapOnSearchButton()


    }

    @Test
    fun verifyEmptyViewUsersReposFieldHasErrorMessage(){
        val searchScreen = SearchScreen()
        val searchResultScreen = SearchScreen().tapOnViewButton()
        val globalTimeOut = 5000L
        val emptyText = ""
        val viewButton = searchScreen.tapOnViewButton()
        val textViewUsersRepo = searchScreen.typeTextInViewUsersReposField(emptyText).tapOnViewButton()
        Thread.sleep(5000)
        searchResultScreen.errorMessage()
        //searchScreen.waitForExists(5000)
                //.waitForExists(globalTimeout)
        //searchResultScreen.errorMessage()



    }


}