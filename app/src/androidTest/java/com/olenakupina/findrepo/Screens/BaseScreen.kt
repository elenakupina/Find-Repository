package com.olenakupina.findrepo.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.pressBack
import android.support.test.uiautomator.UiDevice

open class BaseScreen {
    protected val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())


}