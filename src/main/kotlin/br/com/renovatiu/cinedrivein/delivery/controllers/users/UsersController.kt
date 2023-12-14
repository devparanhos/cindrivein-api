package br.com.renovatiu.cinedrivein.delivery.controllers.users

import br.com.renovatiu.cinedrivein.core.exception.model.ApiResponse
import br.com.renovatiu.cinedrivein.delivery.dto.users.PostUserRequestDTO
import br.com.renovatiu.cinedrivein.delivery.dto.users.toEntity
import br.com.renovatiu.cinedrivein.service.users.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController(
    private val userService: UserService
) {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    fun create(@RequestBody @Valid user: PostUserRequestDTO) : ResponseEntity<ApiResponse> {
        return userService.create(user.toEntity())
    }

}