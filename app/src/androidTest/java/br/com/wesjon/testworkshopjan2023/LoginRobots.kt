package br.com.wesjon.testworkshopjan2023

import android.app.Activity
import android.app.Instrumentation
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText

class loginArrange(action: loginArrange.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun mockHomeActivityCall() {
        intending(hasComponent(HomeActivity::class.java.name))
            .respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))
    }
}

class loginAct(private val composeTestRule: ComposeTestRule, action: loginAct.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun typeEmail(email: String) {
        composeTestRule.onNodeWithTag(TestTags.LoginScreen.EMAIL, true)
            .performTextInput(email)
    }

    fun typePassword(password: String) {
        composeTestRule.onNodeWithTag(TestTags.LoginScreen.PASSWORD, true)
            .performTextInput(password)
    }

    fun clickLogin() {
        composeTestRule.onNodeWithTag(TestTags.LoginScreen.LOGIN_BUTTON, true)
            .performClick()
    }
}

class loginAssert(private val composeTestRule: ComposeTestRule, action: loginAssert.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun assertHomeScreenWasCalled() {
        Intents.intended(hasComponent(HomeActivity::class.java.name))
    }

    fun assertTextWasShown(text: String) {
        onView(withText(text))
            .check(matches(isDisplayed()))
    }

    fun assertTextFieldWithTagIsEmpty(tag: String) {
        composeTestRule.onNodeWithTag(tag, true)
            .assertTextEquals("")
    }
}