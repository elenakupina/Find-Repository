package com.olenakupina.findrepo

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.olenakupina.findrepo.Screens.BaseScreen
import com.olenakupina.findrepo.Screens.SearchScreen
import junit.framework.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchResultTest(): BaseScreen(){

    @Rule
    fun activityRule(): ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java, false, true)

    @Test
    fun matchesLink(){
        val searchScreen = SearchScreen()
        val textSearchForRepo = "Kotlin"
        searchScreen.typeTextInSearchForReposField(textSearchForRepo)
        val searchResultScreen = SearchScreen().tapOnSearchButton()
        val gitHubScreen = searchResultScreen.tapOnARepoInSearchList()
        val actualUrl = gitHubScreen.actualUrl

        val expectedUrl = "https://github.com/JetBrains/kotlin"

        Assert.assertEquals("$actualUrl is equal $expectedUrl", expectedUrl, actualUrl)
    }

    @Test
    fun verifyEmptyViewUsersReposFieldHasErrorMessage(){
        val searchScreen = SearchScreen()
        val emptyText = ""
        searchScreen.typeTextInViewUsersReposField(emptyText)
        val searchResultScreen = searchScreen.tapOnViewButton()
        searchScreen.verifyErrorMessageIsExist()
    }

    @Test
    fun verifyBackWorksOnEachScreen(){
        val searchScreen = SearchScreen()
        val textSearchForRepo = "Kotlin"
        searchScreen.typeTextInSearchForReposField(textSearchForRepo)
        val searchResultScreen = SearchScreen().tapOnSearchButton()
        val gitHubScreen = searchResultScreen.tapOnARepoInSearchList()
        gitHubScreen.back()
        searchResultScreen.back()
    }
}