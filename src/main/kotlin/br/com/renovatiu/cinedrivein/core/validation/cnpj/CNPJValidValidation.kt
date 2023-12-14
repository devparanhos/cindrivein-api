package br.com.renovatiu.cinedrivein.core.validation.cnpj

import br.com.renovatiu.cinedrivein.utils.extensions.isCNPJValid
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class CNPJValidValidation : ConstraintValidator<CNPJValidAnnotation, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return value?.isCNPJValid() == true
    }
}