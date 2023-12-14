package br.com.renovatiu.cinedrivein.core.validation.ancine

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class AncineCineDriveinCodeValidator : ConstraintValidator<AncineDriveinAnnotation, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return value == "5465"
    }
}
