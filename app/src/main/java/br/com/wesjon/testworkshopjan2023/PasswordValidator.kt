package br.com.wesjon.testworkshopjan2023

import br.com.wesjon.testworkshopjan2023.model.PseudoDatabase

class PasswordValidator {
    companion object {
        private val validations = listOf(
            "[\\w\\W]{8,}",
            "[A-Z]",
            "[a-z]",
            "[0-9]",
            "[_\\W]",
            "^(?=\\s*||S).*"
        ).map { it.toRegex() }
    }

    fun isValid(password: String) = validations.all { password.contains(it) }


    fun isInDatabase(email: String, password: String): Boolean {
        val emailAuth = PseudoDatabase.filter { (k,_) -> k == email }

        return if (emailAuth.isNotEmpty()) {
            emailAuth.values.first() == password
        } else false
    }

    fun login(email: String, password: String): Boolean {
        val passwordValid = isValid(password)
        val emailValid = email.contains("@") && email.isNotBlank()

        return passwordValid && emailValid && isInDatabase(email, password)
    }
}
