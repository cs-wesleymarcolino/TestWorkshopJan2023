package br.com.wesjon.testworkshopjan2023

import androidx.annotation.StringRes
import androidx.compose.ui.test.junit4.createEmptyComposeRule
import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @get:Rule
    val composeTestRule = createEmptyComposeRule()


    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun givenInitialState_shouldHaveEmptyEmailAndPasswordCOMPOSE() {
        loginAssert(composeTestRule) {
            assertTextFieldWithTagIsEmpty(TestTags.LoginScreen.EMAIL)
            assertTextFieldWithTagIsEmpty(TestTags.LoginScreen.PASSWORD)
        }
    }

    @Test
    fun givenEmptyEmail_whenLogin_shouldShowEmptyEmailError() {
        loginAct(composeTestRule) {
            typePassword("1aBC1!@3233")

            clickLogin()
        }

        loginAssert(composeTestRule) {
            assertTextWasShown(getString(R.string.error_empty_email))
        }
    }

    @Test
    fun givenEmptyPassword_whenLogin_shouldShowEmptyPasswordError() {
        loginAct(composeTestRule) {
            typeEmail("wesley.marcolino@accenture.com")

            clickLogin()
        }

        loginAssert(composeTestRule) {
            assertTextWasShown(getString(R.string.error_empty_password))
        }
    }

    @Test
    fun givenInvalidPassword_whenLogin_shouldShowInvalidPasswordError() {
        loginAct(composeTestRule) {
            typeEmail("wesley.marcolino@accenture.com")
            typePassword("abcd")

            clickLogin()
        }

        loginAssert(composeTestRule) {
            assertTextWasShown(getString(R.string.error_invalid_password))
        }
    }

    @Test
    fun givenValidEmailAndPassword_whenLogin_shouldGoToHomeScreen() {
        loginArrange {
            mockHomeActivityCall()
        }
        loginArrange{
            mockHomeActivityCall()
        }

        loginAct(composeTestRule) {
            typeEmail("wesley.marcolino@accenture.com")
            typePassword("1aBC1!@3233")

            clickLogin()
        }

        loginAssert(composeTestRule) {
            assertHomeScreenWasCalled()
        }
    }

    private fun getString(@StringRes messageRes: Int): String {
        return InstrumentationRegistry.getInstrumentation().targetContext.getString(messageRes)
    }
}