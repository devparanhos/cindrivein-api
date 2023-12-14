package br.com.renovatiu.cinedrivein.core.validation.ancine

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [AncineCineDriveinCodeValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class AncineDriveinAnnotation(
    val message: String = "O código informado não é do Cine Drive-in",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
