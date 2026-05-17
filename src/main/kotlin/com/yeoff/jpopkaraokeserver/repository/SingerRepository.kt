package com.yeoff.jpopkaraokeserver.repository

import com.yeoff.jpopkaraokeserver.domain.entity.SingerEntity
import com.yeoff.jpopkaraokeserver.repository.projection.SingerListProjection
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SingerRepository : JpaRepository<SingerEntity, Long> {

    @Query("""
        SELECT singer.id, 
               singer.name,
               singer.original_name,
               singer.profile_img,
               count(*) AS songCount
        FROM (
            SELECT singer_id
            FROM song
        
            UNION ALL
        
            SELECT feat_singer_id
            FROM song
            WHERE feat_singer_id IS NOT NULL
        ) t
        JOIN singer ON singer.id = t.singer_id
        GROUP BY singer_id
        HAVING count(*) > 1
        ORDER BY count(*) DESC
        """, nativeQuery = true
    )
    fun findOrderBySongCount(pageable: Pageable): List<SingerListProjection>
}