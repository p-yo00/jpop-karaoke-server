package com.yeoff.jpopkaraokeserver.repository

import com.yeoff.jpopkaraokeserver.domain.entity.SingerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SingerRepository : JpaRepository<SingerEntity, Long> {
    @Query("SELECT singer " +
            "FROM SingerEntity singer " +
            "ORDER BY SIZE(singer.songList) DESC")
    fun findOrderBySongCount(): List<SingerEntity>
}