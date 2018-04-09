package com.olenakupina.findrepo

import android.support.test.rule.ActivityTestRule
import com.olenakupina.findrepo.Screens.SearchScreen
import org.junit.Rule
import org.junit.Test


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

        searchScreen.searchForRepos(textSearchForRepo)
        searchScreen.tapOnSearchButton()


    }

    @Test
    fun verifyEmptyViewUsersReposFieldHasErrorMessage(){
        val searchScreen = SearchScreen()
        val searchResultScreen = SearchScreen().tapOnViewButton()

        val emptyText = ""
        val textViewUsersRepo = searchScreen.viewUsersRepos(emptyText)



    }


}