package br.com.renovatiu.cinedrivein.core.exception.model

sealed class ApiResponse() {
    data class Error(
        val httpCode: Int,
        val message: String,
        val errors: List<FieldErrorResponse>? = null
    ) : ApiResponse()

    data class Success(
        val message: String,
        val data: Any?
    ) : ApiResponse()
}