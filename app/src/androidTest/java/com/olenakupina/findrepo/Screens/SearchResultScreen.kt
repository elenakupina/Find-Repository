package com.olenakupina.findrepo.Screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.olenakupina.findrepo.R

class SearchResultScreen(){

    init {
        onView(withId(R.id.repoListView))
                .check(matches(isDisplayed()))
    }

    fun tapOnARepoInSearchList(text: String): GitHubScreen{
         onView(withText(text))
                 .perform(click())
        return GitHubScreen()
    }


}