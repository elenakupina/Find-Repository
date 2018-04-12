package com.olenakupina.findrepo.Screens



import android.support.test.uiautomator.UiSelector
import junit.framework.Assert

class GitHubScreen(): BaseScreen() {

    val url = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar"))
    //val urlTextField = uiDevice.findObject(UiSelector().resourceId("us.moviemates:id/tvNameValue"))
    val actualUrl get() = url.text

    init {
        Assert.assertTrue("GitHub page isn’t open", url.waitForExists(3000))
    }

    fun back(): SearchResultScreen{
        uiDevice.pressBack()
        return SearchResultScreen()
    }

}