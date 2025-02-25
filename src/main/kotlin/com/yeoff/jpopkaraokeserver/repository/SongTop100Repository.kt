package com.yeoff.jpopkaraokeserver.repository

import com.yeoff.jpopkaraokeserver.domain.entity.SongTop100Entity
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SongTop100Repository : JpaRepository<SongTop100Entity, Long> {

    @Query("SELECT songTop100 " +
            "FROM SongTop100Entity songTop100 " +
            "JOIN FETCH songTop100.singer")
    fun findTop100(pageable: Pageable): List<SongTop100Entity>
}