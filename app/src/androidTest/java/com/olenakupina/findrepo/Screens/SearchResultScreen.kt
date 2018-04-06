package com.olenakupina.findrepo.Screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.olenakupina.findrepo.R

class SearchResultScreen(){

    init {
        onView(withId(R.id.repoListView))
                .check(matches(isDisplayed()))
    }


}