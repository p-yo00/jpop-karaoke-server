package com.yeoff.jpopkaraokeserver.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.LocalDateTime

@Entity
@Table(name = "song")
class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToOne
    @JoinColumn(name = "singer_id")
    val singer: SingerEntity? = null

    @ManyToOne
    @JoinColumn(name = "feat_singer_id")
    val featSinger: SingerEntity? = null

    val title: String? = null
    val originalTitle: String? = null

    val ky: Int? = null
    val tj: Int? = null

    val youtubeUrl: String? = null
    val albumImg: String? = null

    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(columnDefinition = "JSON")
    @JdbcTypeCode(SqlTypes.JSON)
    val keyword: List<String> = ArrayList()

    fun concatSinger(): String? {
        featSinger?.let { return singer?.name + " (feat." + it.name + ")" }
        return singer?.name
    }
}