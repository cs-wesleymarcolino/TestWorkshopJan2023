package br.com.wesjon.testworkshopjan2023

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {
    private val passwordValidator = PasswordValidator()
    @Test
    fun givenPasswordIsShorterThan8_whenValidate_shouldReturnFalse(){
        val result = passwordValidator.isValid("1234567")

        assertFalse(result)
    }

    @Test
    fun givenEmailAndPasswordIsInDatabase_shouldReturnFalse(){
        val result = passwordValidator.isInDatabase("anderson@acenture.com", "Soneca#45a")

        assertFalse(result)
    }

    @Test
    fun givenEmailAndPasswordIsInDatabase_shouldReturnTrue(){
        val result = passwordValidator.isInDatabase("ricardo@accenture.com", "baNana*ç88")

        assertTrue(result)
    }

    @Test
    fun givenEmailAndPassWordInLoginScreen_shouldReturnFalse(){
        val result = passwordValidator.login("elisangelaaccenture.com", "saO8oito%")

        assertFalse(result)
    }

    @Test
    fun givenEmailAndPassWordInLoginScreen_shouldReturnTrue(){
        val result = passwordValidator.login("elisangela@accenture.com", "saO8oito%")

        assertTrue(result)
    }

}