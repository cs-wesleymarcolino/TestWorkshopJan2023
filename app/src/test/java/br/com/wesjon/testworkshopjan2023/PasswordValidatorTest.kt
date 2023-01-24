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
    fun givenPasswordIsALeastOneCharacterIsUppercase_shouldReturnTrue(){
        val result = passwordValidator.isUppercase("Samanta")
        assertTrue(result)
    }

    @Test
    fun givenPasswordIsALeastOneCharacterIsLowercase_shouldReturnTrue(){
        val result = passwordValidator.isLowerCase("Amelia")
        assertTrue(result)
    }

    @Test
    fun givenPasswordIsALeastOneCharacterIsNumber_shouldReturnTrue(){
        val result = passwordValidator.isNumber("Paulinho13")
        assertTrue(result)
    }

    @Test
    fun givenPasswordIsALeastOneCharacterIsSpecialCharacter_shouldReturnTrue(){
        val result = passwordValidator.isSpecialCharacter("Vinicius@13")
        assertTrue(result)
    }

}