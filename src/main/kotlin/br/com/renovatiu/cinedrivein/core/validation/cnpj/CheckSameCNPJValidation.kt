package br.com.renovatiu.cinedrivein.core.validation.cnpj

import br.com.renovatiu.cinedrivein.service.distributors.DistributorService
import br.com.renovatiu.cinedrivein.utils.extensions.isCNPJValid
import br.com.renovatiu.cinedrivein.utils.extensions.numericCNPJ
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class CheckSameCNPJValidation(
    private val distributorService: DistributorService
) : ConstraintValidator<CheckSameCNPJAnnotation, CheckSameCNPJModel> {
    override fun isValid(value: CheckSameCNPJModel?, context: ConstraintValidatorContext?): Boolean {
        value?.let {
            val distributor = distributorService.getById(it.id)
            if (distributor.cnpj != it.cnpj.numericCNPJ()){
                return distributorService.isCnpjAvailable(it.cnpj.numericCNPJ().toString())
            } else {
                return it.cnpj.isCNPJValid()
            }
        } ?: run {
            return false
        }
    }
}