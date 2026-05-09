package com.yeoff.jpopkaraokeserver.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.LocalDateTime

@Entity
@Table(name = "singer")
class SingerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1

    val name: String? = null
    val originalName: String? = null
    val profileImg: String? = null

    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(columnDefinition = "JSON")
    @JdbcTypeCode(SqlTypes.JSON)
    val keyword: ArrayList<String> = ArrayList()

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "singer_id")
    val songList: List<SongEntity> = ArrayList()
}