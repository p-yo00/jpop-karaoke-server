package com.yeoff.jpopkaraokeserver.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "lyrics")
class LyricsEntity(
    @ManyToOne @JoinColumn(name = "song_id")
    val song: SongEntity,
    val sequence: Int,
    val jpn: String?,
    val kor: String?,
    val rom: String?
) {
    @Id @GeneratedValue val id: Long? = null
}