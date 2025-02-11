package com.yeoff.jpopkaraokeserver.repository

import com.yeoff.jpopkaraokeserver.domain.entity.SongEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface SongRepository : JpaRepository<SongEntity, Long>
interface SongRepository : JpaRepository<SongEntity, Long> {

    @Query("SELECT song.* " +
            "FROM song " +
            "JOIN singer ON song.singer_id = singer.id " +
            "WHERE song.title LIKE CONCAT('%', :keyword, '%') " +
            "OR singer.name LIKE CONCAT('%', :keyword, '%') " +
            "OR JSON_SEARCH(song.keyword, 'all', CONCAT('%', :keyword, '%')) " +
            "OR JSON_SEARCH(singer.keyword, 'all', CONCAT('%', :keyword, '%'))"
        , nativeQuery = true)
    fun findByKeyword(@Param("keyword") keyword: String, pageable: Pageable): Page<SongEntity>
}