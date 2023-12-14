package br.com.renovatiu.cinedrivein.repository.datasource

import br.com.renovatiu.cinedrivein.repository.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UsersRepository : JpaRepository<UserEntity, Int> {
    @Query(value = "SELECT COUNT(*) FROM USERS WHERE EMAIL = ?1", nativeQuery = true)
    fun isEmailAvailable(email: String) : Long
}