package br.com.renovatiu.cinedrivein.core.validation.cnpj

import br.com.renovatiu.cinedrivein.service.distributors.DistributorService
import br.com.renovatiu.cinedrivein.utils.extensions.numericCNPJ
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class CNPJAvailableValidation(
    private val distributorService: DistributorService
) : ConstraintValidator<CNPJAvailableAnnotation, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        value?.let {
            return  distributorService.isCnpjAvailable(cnpj = it.numericCNPJ().toString())
        } ?: run {
            return false
        }
    }
}