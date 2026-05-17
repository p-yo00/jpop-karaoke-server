package com.yeoff.jpopkaraokeserver.repository

import com.yeoff.jpopkaraokeserver.domain.entity.SongEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface SongRepository : JpaRepository<SongEntity, Long> {

    @Query("""
        SELECT DISTINCT s
        FROM SongEntity s
        LEFT JOIN FETCH s.singer
        LEFT JOIN FETCH s.featSinger
        WHERE s.singer.id = :singerId
        OR s.featSinger.id = :singerId
    """)
    fun findBySingerId(singerId: Long, pageable: Pageable): List<SongEntity>

    @Query("SELECT song.* " +
            "FROM song " +
            "JOIN singer ON song.singer_id = singer.id " +
            "LEFT JOIN singer AS feat ON song.feat_singer_id = feat.id " +
            "WHERE song.title LIKE CONCAT('%', :keyword, '%') " +
            "OR singer.name LIKE CONCAT('%', :keyword, '%') " +
            "OR feat.name LIKE CONCAT('%', :keyword, '%') " +
            "OR JSON_SEARCH(song.keyword, 'all', CONCAT('%', :keyword, '%')) " +
            "OR JSON_SEARCH(singer.keyword, 'all', CONCAT('%', :keyword, '%')) " +
            "OR JSON_SEARCH(feat.keyword, 'all', CONCAT('%', :keyword, '%'))"
        , nativeQuery = true)
    fun findByKeyword(@Param("keyword") keyword: String, pageable: Pageable): List<SongEntity>

    @Query("""
        SELECT song
        FROM SongTop100Entity top100
        JOIN top100.song song
        JOIN FETCH song.singer
        LEFT JOIN FETCH song.featSinger
        ORDER BY top100.chartRank
    """)
    fun findTop100Songs(pageable: Pageable): List<SongEntity>
}