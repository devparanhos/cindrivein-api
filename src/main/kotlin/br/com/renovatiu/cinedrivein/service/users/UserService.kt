package br.com.renovatiu.cinedrivein.service.users

import br.com.renovatiu.cinedrivein.core.exception.enums.Errors
import br.com.renovatiu.cinedrivein.core.exception.enums.Success
import br.com.renovatiu.cinedrivein.core.exception.model.ApiResponse
import br.com.renovatiu.cinedrivein.delivery.dto.users.toResponseDTO
import br.com.renovatiu.cinedrivein.repository.datasource.UsersRepository
import br.com.renovatiu.cinedrivein.repository.entity.UserEntity
import com.google.common.hash.Hashing
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class UserService(
    private val repository: UsersRepository
) {
    fun create(user: UserEntity) : ResponseEntity<ApiResponse>{
        return try {
            val hashData = Hashing.sha256()
            val saveResult = repository.save(user.copy(password = hashData.hashString(user.password, Charsets.UTF_8).toString()))
            val result = ApiResponse.Success(message = Success.CDIS001.message, data = saveResult.toResponseDTO())

            ResponseEntity(result, HttpStatus.CREATED)
        } catch (e: Exception) {
            val errorResponse = ApiResponse.Error(
                httpCode = 500,
                message = Errors.CDIE001.message
            )

            ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
        }
    }

    fun isEmailAvailable(email: String) : Boolean{
        return repository.isEmailAvailable(email) <= 0
    }
}