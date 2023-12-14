package br.com.renovatiu.cinedrivein.repository.datasource

import br.com.renovatiu.cinedrivein.repository.entity.MovieEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository : JpaRepository<MovieEntity, Int> {
    fun findByTitleContainingOrderByIdDesc(name : String) : List<MovieEntity>
}