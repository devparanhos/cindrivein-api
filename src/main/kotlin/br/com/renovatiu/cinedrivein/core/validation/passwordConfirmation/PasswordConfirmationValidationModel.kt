package br.com.renovatiu.cinedrivein.core.validation.passwordConfirmation

data class PasswordConfirmationValidationModel(
    val password: String,
    val confirmationPassword: String
)
