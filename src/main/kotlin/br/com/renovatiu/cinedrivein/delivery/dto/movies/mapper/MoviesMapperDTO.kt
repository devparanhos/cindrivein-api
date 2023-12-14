package br.com.renovatiu.cinedrivein.delivery.dto.movies.mapper

import br.com.renovatiu.cinedrivein.delivery.dto.distributors.toGetDistributorResponseDto
import br.com.renovatiu.cinedrivein.delivery.dto.movies.request.PostMovieRequestDTO
import br.com.renovatiu.cinedrivein.delivery.dto.movies.request.PutMovieRequestDTO
import br.com.renovatiu.cinedrivein.delivery.dto.movies.response.GetMovieResponseDTO
import br.com.renovatiu.cinedrivein.repository.entity.DistributorEntity
import br.com.renovatiu.cinedrivein.repository.entity.MovieEntity

fun PostMovieRequestDTO.toEntity(distributor: DistributorEntity) : MovieEntity {
    return MovieEntity(
        title = this.title,
        poster = this.poster,
        backdrop = this.backdrop,
        cpb = this.cpb,
        distributor = distributor
    )
}

fun PutMovieRequestDTO.toEntity(distributor: DistributorEntity) : MovieEntity {
    return MovieEntity(
        title = this.title,
        poster = this.poster,
        backdrop = this.backdrop,
        cpb = this.cpb,
        distributor = distributor
    )
}

fun MovieEntity.toGetMovieResponseDTO() : GetMovieResponseDTO {
    return GetMovieResponseDTO(
        id = this.id,
        title = this.title,
        poster = this.poster,
        backdrop = this.backdrop,
        cpb = this.cpb,
        distributor = this.distributor.toGetDistributorResponseDto()
    )
}