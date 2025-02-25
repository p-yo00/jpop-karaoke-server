package com.yeoff.jpopkaraokeserver.repository

import com.yeoff.jpopkaraokeserver.domain.dto.SingerListRespDto
import com.yeoff.jpopkaraokeserver.domain.entity.SingerEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SingerRepository : JpaRepository<SingerEntity, Long> {
    @Query("SELECT new com.yeoff.jpopkaraokeserver.domain.dto.SingerListRespDto(singer, count(*)) " +
            "FROM SingerEntity singer " +
            "JOIN FETCH SongEntity song ON singer.id = song.singer.id " +
            "GROUP BY singer.id " +
            "HAVING count(*) > 1"+
            "ORDER BY count(*) DESC")
    fun findOrderBySongCount(pageable: Pageable): List<SingerListRespDto>
}