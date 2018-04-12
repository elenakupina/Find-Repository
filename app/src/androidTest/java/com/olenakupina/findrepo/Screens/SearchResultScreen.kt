package com.olenakupina.findrepo.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.uiautomator.UiSelector
import com.olenakupina.findrepo.R
import org.hamcrest.CoreMatchers

class SearchResultScreen(): BaseScreen(){

    val repoResultList = Espresso.onData(CoreMatchers.anything())
            .inAdapterView(CoreMatchers.allOf(ViewMatchers.withId(R.id.repoListView)))!!

    val repoIndex =  uiDevice.findObject(UiSelector().className("android.widget.TextView").index(1))

    val chromeBrowser = uiDevice.findObject(UiSelector().className("android.widget.FrameLayout").index(0))!!


    val waitForResults = uiDevice.findObject(UiSelector().className("android.widget.FrameLayout").index(0))




    init {
        onView(withId(R.id.repoListView))
                .check(matches(isDisplayed()))
    }

    fun tapOnARepoInSearchList(): GitHubScreen{
         repoIndex.click()
        return GitHubScreen()
    }

    fun back(): SearchScreen{
        uiDevice.pressBack()
        return SearchScreen()
    }

    fun verifyWeAreOnSearchRusultScreen(): SearchResultScreen{
        onView(withId(R.id.repoListView))
                .check(matches(isDisplayed()))
        return SearchResultScreen()
    }
}