package br.com.wesjon.testworkshopjan2023

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {
    private val passwordValidator = PasswordValidator()

    @Test
    fun givenPasswordIsShorterThan8_whenValidate_shouldReturnFalse(){
        val result = passwordValidator.isValid("aB!91")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesnHaveUppercaseLetter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("ab!9112322")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesnHaveLowercaseLetter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("AB!9112322")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesnHaveANumber_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("ab!Ecdedflgs")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesnHaveASpecialCharacter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("abDEcdedflgs")

        assertFalse(result)
    }


    @Test
    fun givenPasswordIsValid_whenValidate_shouldReturnTrue() {
        val result = passwordValidator.isValid("aB!c9123456")

        assertTrue(result)
    }
}