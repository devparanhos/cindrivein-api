package br.com.renovatiu.cinedrivein.core.validation.cnpj

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [CNPJValidValidation::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class CNPJValidAnnotation(
    val message: String = "CNPJ informado é inválido",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
