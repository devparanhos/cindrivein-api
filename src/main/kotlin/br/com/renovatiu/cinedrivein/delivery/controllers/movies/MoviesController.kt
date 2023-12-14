package br.com.renovatiu.cinedrivein.delivery.controllers.movies

import br.com.renovatiu.cinedrivein.core.exception.model.ApiResponse
import br.com.renovatiu.cinedrivein.delivery.dto.movies.request.PostMovieRequestDTO
import br.com.renovatiu.cinedrivein.delivery.dto.movies.mapper.toEntity
import br.com.renovatiu.cinedrivein.delivery.dto.movies.mapper.toGetMovieResponseDTO
import br.com.renovatiu.cinedrivein.delivery.dto.movies.request.PutMovieRequestDTO
import br.com.renovatiu.cinedrivein.delivery.dto.movies.response.GetMovieResponseDTO
import br.com.renovatiu.cinedrivein.service.distributors.DistributorService
import br.com.renovatiu.cinedrivein.service.movies.MovieService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("movies")
class MoviesController(
    private val distributorService: DistributorService,
    private val movieService: MovieService
) {

    @PostMapping
    fun create(@RequestBody @Valid movie: PostMovieRequestDTO): ResponseEntity<ApiResponse>{
        val distributor = distributorService.getById(id = movie.distributorId)
        return movieService.create(movieEntity = movie.toEntity(distributor = distributor))
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) : GetMovieResponseDTO{
        return movieService.getById(id = id).toGetMovieResponseDTO()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody movie: PutMovieRequestDTO) {
        val distributor = distributorService.getById(id = movie.distributorId)
        movieService.update(id = id, movie = movie.toEntity(distributor = distributor))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        movieService.delete(id = id)
    }

    @GetMapping
    fun getAll(@RequestParam title: String?) : List<GetMovieResponseDTO>{
        return movieService.getAll(title = title).map { it.toGetMovieResponseDTO() }
    }
}