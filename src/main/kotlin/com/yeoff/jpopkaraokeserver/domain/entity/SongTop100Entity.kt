package com.yeoff.jpopkaraokeserver.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "song_top100")
class SongTop100Entity(
    val title: String?,
    @ManyToOne @JoinColumn(name = "singer_id")
    val singer: SingerEntity?,
    val originalTitle: String?,
    val youtubeUrl: String?,
    val albumImg: String?,
    val ky: Int?,
    val tj: Int?,
    @Column(columnDefinition = "JSON") @JdbcTypeCode(SqlTypes.JSON)
    val keyword: List<String>?
) {
    @Id @GeneratedValue val id: Long? = null
}