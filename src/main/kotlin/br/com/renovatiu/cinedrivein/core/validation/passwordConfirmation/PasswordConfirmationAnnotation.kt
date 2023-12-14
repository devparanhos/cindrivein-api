package br.com.renovatiu.cinedrivein.core.validation.passwordConfirmation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [PasswordConfirmationValidation::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class PasswordConfirmationAnnotation(
    val message: String = "As senhas precisam ser as mesmas",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
