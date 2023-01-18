package br.com.wesjon.testworkshopjan2023

import org.junit.Assert.assertFalse
import org.junit.Test

class PasswordValidatorTest {
    private val passwordValidator = PasswordValidator()

    @Test
    fun givenPasswordIsShorterThan8_whenValidate_shouldReturnFalse(){
        val result = passwordValidator.isValid("1234567")

        assertFalse(result)
    }
}