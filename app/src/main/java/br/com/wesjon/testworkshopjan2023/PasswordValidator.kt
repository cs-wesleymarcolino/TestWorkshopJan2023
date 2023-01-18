package br.com.wesjon.testworkshopjan2023

class PasswordValidator {
    companion object{
        private const val MIN_PASSWORD_LENGTH = 8
    }
    fun isValid(password: String): Boolean {
        return password.length >= MIN_PASSWORD_LENGTH
    }
}
