package br.com.renovatiu.cinedrivein.core.validation.email

import br.com.renovatiu.cinedrivein.service.users.UserService
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class EmailAvailableValidation(
        private val userService: UserService
) : ConstraintValidator<EmailAvailableAnnotation, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        value?.let {
            return userService.isEmailAvailable(it)
        } ?: run {
            return false
        }
    }
}