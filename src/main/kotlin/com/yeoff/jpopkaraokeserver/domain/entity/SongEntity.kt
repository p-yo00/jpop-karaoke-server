package com.yeoff.jpopkaraokeserver.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "song")
class SongEntity(
    val title: String?,
    val singer: String?,
    val originalTitle: String?,
    val lyrics: String?,
    val youtubeUrl: String?,
    val albumImg: String?,
    val ky: Int?,
    val tj: Int?,
    val keyword: String?
) {
    @Id @GeneratedValue val id: Long? = null
}