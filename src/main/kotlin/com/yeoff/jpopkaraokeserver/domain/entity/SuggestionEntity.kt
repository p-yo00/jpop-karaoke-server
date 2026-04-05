package com.yeoff.jpopkaraokeserver.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "suggestion")
class SuggestionEntity(
    val content: String?,
) {
    @Id @GeneratedValue
    val id: Long? = null

    val writeDatetime: LocalDateTime = LocalDateTime.now()

    companion object {
        fun create(content: String): SuggestionEntity {
            return SuggestionEntity(content)
        }
    }
}