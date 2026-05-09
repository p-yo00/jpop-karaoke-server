package com.yeoff.jpopkaraokeserver.domain.entity

import jakarta.persistence.*
import lombok.NoArgsConstructor

@Entity
@NoArgsConstructor
@Table(name = "lyrics")
class LyricsEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToOne
    @JoinColumn(name = "song_id")
    val song: SongEntity? = null

    val sequence: Int? = null
    val jpn: String? = null
    val kor: String? = null
    val rom: String? = null
}