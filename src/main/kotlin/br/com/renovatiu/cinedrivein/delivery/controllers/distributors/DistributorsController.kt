package br.com.renovatiu.cinedrivein.delivery.controllers.distributors

import br.com.renovatiu.cinedrivein.delivery.dto.distributors.*
import br.com.renovatiu.cinedrivein.service.distributors.DistributorService
import jakarta.validation.Valid
import jakarta.websocket.server.PathParam
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("distributors")
class DistributorsController(
    private val distributorService: DistributorService
) {

    @PostMapping
    fun create(@RequestBody @Valid distributor: PostDistributorRequestDTO) {
        distributorService.create(distributor = distributor.toEntity())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) : GetDistributorResponseDTO{
        return distributorService.getById(id).toGetDistributorResponseDto()
    }

    @GetMapping
    fun getAll() : List<GetDistributorResponseDTO> {
        return distributorService.getAll()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        distributorService.delete(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody @Valid distributor: PutDistributorRequestDTO) {
        distributorService.update(id = id, distributor = distributor.toEntity())
    }
}