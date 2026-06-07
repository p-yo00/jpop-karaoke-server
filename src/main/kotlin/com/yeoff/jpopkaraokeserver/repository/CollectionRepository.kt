package com.yeoff.jpopkaraokeserver.repository

import com.yeoff.jpopkaraokeserver.domain.entity.CollectionEntity
import com.yeoff.jpopkaraokeserver.domain.entity.SongEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CollectionRepository : JpaRepository<CollectionEntity, Long> {

    @Query("""
        SELECT c
        FROM CollectionEntity c
        WHERE c.isActive = true
        ORDER BY c.orders
    """)
    fun findActiveCollections(): List<CollectionEntity>

    @Query("""
        SELECT cs.song
        FROM CollectionSongEntity cs
        WHERE cs.collection.id = :id
    """)
    fun findCollectionSongById(id: Long, pageable: Pageable): Page<SongEntity>
}