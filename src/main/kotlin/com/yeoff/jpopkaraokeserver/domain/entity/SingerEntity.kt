package com.yeoff.jpopkaraokeserver.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "singer")
class SingerEntity(
    val name: String?,
    val originalName: String?,
    val profileImg: String?,
    @Column(columnDefinition = "JSON") @JdbcTypeCode(SqlTypes.JSON)
    val keyword: ArrayList<String>?
) {
    @Id @GeneratedValue val id: Long? = null
}