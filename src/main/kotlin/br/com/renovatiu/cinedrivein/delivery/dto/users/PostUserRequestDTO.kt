package br.com.renovatiu.cinedrivein.delivery.dto.users

import br.com.renovatiu.cinedrivein.core.validation.ancine.AncineDriveinAnnotation
import br.com.renovatiu.cinedrivein.core.validation.email.EmailAvailableAnnotation
import br.com.renovatiu.cinedrivein.core.validation.passwordConfirmation.PasswordConfirmationAnnotation
import br.com.renovatiu.cinedrivein.core.validation.passwordConfirmation.PasswordConfirmationValidationModel
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class PostUserRequestDTO(
    @field:NotEmpty(message = "O nome é obrigatório")
    val name: String,

    @field:NotEmpty(message = "O e-mail é obrigatório")
    @field:Email(message = "O e-mail é inválido")
    @EmailAvailableAnnotation
    val email: String,

    @field:NotEmpty(message = "A senha é obrigatória")
    @field:Size(min = 6, message = "A senha deve conter pelo menos 6 caracteres")
    val password: String,

    @field:NotEmpty(message = "A confirmação de senha é obrigatória")
    val confirmPassword: String,

    @PasswordConfirmationAnnotation
    val passwordValidator: PasswordConfirmationValidationModel = PasswordConfirmationValidationModel(
        password = password,
        confirmationPassword = confirmPassword
    ),

    @field:NotEmpty(message = "O código ancine é obrigatório")
    @AncineDriveinAnnotation
    val ancineCode: String
)

