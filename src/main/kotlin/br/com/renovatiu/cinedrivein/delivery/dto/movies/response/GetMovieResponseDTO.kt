package br.com.renovatiu.cinedrivein.delivery.dto.movies.response

import br.com.renovatiu.cinedrivein.delivery.dto.distributors.GetDistributorResponseDTO

data class GetMovieResponseDTO(
    val id: Int?,
    val title: String,
    val poster: String?,
    val backdrop: String?,
    val cpb: String,
    val distributor: GetDistributorResponseDTO
)
