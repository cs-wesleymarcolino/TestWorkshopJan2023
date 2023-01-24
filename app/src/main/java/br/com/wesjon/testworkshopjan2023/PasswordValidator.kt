package br.com.wesjon.testworkshopjan2023

import java.util.regex.Pattern

class PasswordValidator {
    companion object{
        private const val MIN_PASSWORD_LENGTH = 8
    }
    fun isValid(password: String): Boolean {
        return password.length >= MIN_PASSWORD_LENGTH
    }

    fun isUppercase(password: String): Boolean {
        val chars = password.toCharArray()
        val upper = chars.filter { it.isUpperCase() }
        return upper.isNotEmpty()
    }

    fun isLowerCase(password: String): Boolean {
        val chars = password.toCharArray()
        val lower = chars.filter { it.isLowerCase() }
        return lower.isNotEmpty()
    }

    fun isNumber(password: String): Boolean {
        val chars = password.toCharArray()
        val hasNumber = chars.filter { it.isDigit() }
        return hasNumber.isNotEmpty()
    }

    fun isSpecialCharacter(password: String): Boolean {
        val pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE)
        val hasSpecial = pattern.matcher(password)
        return hasSpecial.find()
    }
}
