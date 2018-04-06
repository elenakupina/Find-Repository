package com.olenakupina.findrepo.Screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.olenakupina.findrepo.R

class SearchScreen(){

    init {
        onView(withId(R.id.searchEditText))
                .check(matches(isDisplayed()))
    }

    fun searchForRepos(text: String): SearchScreen{
        onView(withId(R.id.searchEditText))
                .perform(typeText(text))
        return this
    }

    fun viewUsersRepos(text: String): SearchScreen{
        onView(withId(R.id.userRepoEditText))
                .perform(typeText(text))
        return this
    }

    fun tapOnSearchButton(): SearchResultScreen{
        onView(withId(R.id.searchButton))
                .perform(click())
        return SearchResultScreen()
    }

    fun tapOnViewButton(): SearchResultScreen{
        onView(withId(R.id.userRepoButton))
                .perform(click())
        return SearchResultScreen()
    }



}