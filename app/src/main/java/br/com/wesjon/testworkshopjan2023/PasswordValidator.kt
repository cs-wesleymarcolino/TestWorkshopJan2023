package br.com.wesjon.testworkshopjan2023

class PasswordValidator {
    companion object {
        private val validations = listOf(
            "[\\w\\W]{8,}",
            "[A-Z]",
            "[a-z]",
            "[0-9]",
            "[_\\W]"
        ).map { it.toRegex() }
    }

    fun isValid(password: String) = validations.all { password.contains(it) }
}
