package br.com.renovatiu.cinedrivein.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity(name = "sessions")
data class SessionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "movie_id")
    val movie: MovieEntity,

    @ManyToOne
    @JoinColumn(name = "room_id")
    val room: RoomEntity,

    @Column
    val date: String,

    @Column
    val time: String,

    @Column(name = "original_audio")
    val originalAudio: Boolean,

    @Column
    val subtitle: Boolean,

    @Column(name = "default_screen")
    val defaultScreen: Boolean,

    @Column
    val digital: Boolean,

    @Column(name = "3d")
    val is3D: Boolean,

    @Column
    val signs: Boolean,

    @Column(name = "subtitle_description")
    val subtitleDescription: Boolean,

    @Column(name = "audio_description")
    val audioDescription: Boolean,

    @Column
    val published: Boolean
)
