package com.yeoff.jpopkaraokeserver.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "song_top100")
class SongTop100Entity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id")
    val song: SongEntity? = null

    val chartRank: Short? = null

    val batchDateTime: LocalDateTime? = null
}