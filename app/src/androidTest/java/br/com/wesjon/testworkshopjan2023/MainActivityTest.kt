package br.com.wesjon.testworkshopjan2023

import androidx.annotation.StringRes
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createEmptyComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val composeTestRule = createEmptyComposeRule()

    @Test
    @Ignore("This test is only an example")
    fun givenInitialState_shouldHaveEmptyEmailAndPasswordNATIVE() {
        onView(withId(R.id.et_email))
            .check(matches(withText("")))

        onView(withId(R.id.et_password))
            .check(matches(withText("")))
    }

    @Test
    fun givenInitialState_shouldHaveEmptyEmailAndPasswordCOMPOSE() {
        composeTestRule.onNodeWithTag(TestTags.LoginScreen.EMAIL, true)
            .assertTextEquals("")

        composeTestRule.onNodeWithTag(TestTags.LoginScreen.PASSWORD, true)
            .assertTextEquals("")
    }

    @Test
    fun givenEmptyEmail_whenLogin_shouldShowEmptyEmailError() {
        composeTestRule.onNodeWithTag(TestTags.LoginScreen.PASSWORD, true)
            .performTextInput("1aBC1!@3233")

        composeTestRule.onNodeWithTag(TestTags.LoginScreen.LOGIN_BUTTON, true)
            .performClick()

        onView(withText(R.string.error_empty_email))
            .check(matches(isDisplayed()))
    }

    private fun getString(@StringRes messageRes: Int): String {
        return InstrumentationRegistry.getInstrumentation().targetContext.getString(messageRes)
    }
}