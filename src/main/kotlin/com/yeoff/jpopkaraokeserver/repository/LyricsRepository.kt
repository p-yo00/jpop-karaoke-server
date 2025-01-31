package com.yeoff.jpopkaraokeserver.repository

import com.yeoff.jpopkaraokeserver.domain.entity.LyricsEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LyricsRepository : JpaRepository<LyricsEntity, Long> {

    fun findBySong_IdOrderBySequence(id: Long): List<LyricsEntity>
}