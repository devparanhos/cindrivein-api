package br.com.renovatiu.cinedrivein.service.movies

import br.com.renovatiu.cinedrivein.core.exception.model.ApiResponse
import br.com.renovatiu.cinedrivein.delivery.dto.movies.mapper.toGetMovieResponseDTO
import br.com.renovatiu.cinedrivein.repository.datasource.MovieRepository
import br.com.renovatiu.cinedrivein.repository.entity.MovieEntity
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class MovieService(
    private val repository: MovieRepository
) {
    fun create(movieEntity: MovieEntity) : ResponseEntity<ApiResponse>{
        return try {
            val result = ApiResponse.Success(message = "", data = repository.save(movieEntity).toGetMovieResponseDTO())
            ResponseEntity(result, HttpStatus.CREATED)
        } catch (exception: Exception) {
            ResponseEntity(ApiResponse.Error(httpCode = 500, message = "Algo deu errado"), HttpStatus.BAD_REQUEST)
        }
    }

    fun getById(id: Int) : MovieEntity {
        return repository.findById(id).orElseThrow()
    }

    fun update(id: Int, movie: MovieEntity) {
        val result = getById(id)
        repository.save(
            result.copy(
                title = movie.title,
                poster = movie.poster,
                backdrop = movie.backdrop,
                cpb = movie.cpb,
                distributor = movie.distributor
            )
        )
    }

    fun delete(id: Int){
        repository.deleteById(id)
    }

    fun getAll(title: String?) : List<MovieEntity>{
        title?.let {
            return repository.findByTitleContainingOrderByIdDesc(it)
        } ?: run {
            return repository.findAll(Sort.by(Sort.Order.desc("id")))
        }
    }
}