package br.com.renovatiu.cinedrivein.core.exception.advice

import br.com.renovatiu.cinedrivein.core.exception.enums.Errors
import br.com.renovatiu.cinedrivein.core.exception.model.ApiResponse
import br.com.renovatiu.cinedrivein.core.exception.model.FieldErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException, webRequest: WebRequest) : ResponseEntity<ApiResponse> {
        val apiResponse = ApiResponse.Error(
            httpCode = HttpStatus.UNPROCESSABLE_ENTITY.value(),
            message = Errors.CDIE002.message,
            errors = exception.bindingResult.fieldErrors.map {
                FieldErrorResponse(
                    messsage = it.defaultMessage ?: Errors.CDIE001.message,
                    field = it.field
                )
            }
        )

        return ResponseEntity(apiResponse, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}