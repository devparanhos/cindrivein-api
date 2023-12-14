package br.com.renovatiu.cinedrivein.core.validation.passwordConfirmation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class PasswordConfirmationValidation : ConstraintValidator<PasswordConfirmationAnnotation, PasswordConfirmationValidationModel> {
    override fun isValid(value: PasswordConfirmationValidationModel?, context: ConstraintValidatorContext?): Boolean {
        return value?.confirmationPassword == value?.password
    }
}