package br.com.renovatiu.cinedrivein.delivery.dto.users

import br.com.renovatiu.cinedrivein.repository.entity.UserEntity
import com.google.common.hash.Hashing
import org.checkerframework.common.returnsreceiver.qual.This

fun PostUserRequestDTO.toEntity() : UserEntity {
    return UserEntity(
        name = this.name,
        email = this.email,
        password = this.password,
        ancineCode = this.ancineCode
    )
}

fun UserEntity.toResponseDTO() : PostUserResponseDTO {
    return PostUserResponseDTO(
        id = this.id,
        email = this.email,
        name = this.name,
        ancineCode = this.ancineCode
    )
}