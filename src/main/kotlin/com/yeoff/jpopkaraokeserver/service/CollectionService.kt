package com.yeoff.jpopkaraokeserver.service

import com.yeoff.jpopkaraokeserver.domain.dto.CollectionCreateReq
import com.yeoff.jpopkaraokeserver.domain.dto.CollectionListResp
import com.yeoff.jpopkaraokeserver.domain.dto.SongListRespDto
import com.yeoff.jpopkaraokeserver.domain.entity.CollectionEntity
import com.yeoff.jpopkaraokeserver.domain.entity.CollectionSongEntity
import com.yeoff.jpopkaraokeserver.repository.CollectionRepository
import com.yeoff.jpopkaraokeserver.util.PageUtil
import org.hibernate.query.Page
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class CollectionService(val collectionRepository: CollectionRepository) {

    fun getCollections(): List<CollectionListResp> {
        return collectionRepository.findActiveCollections()
            .map { CollectionListResp.from(it) }
    }

    fun getCollectionSong(collectionId: Long, page: Int?, size: Int?)
            : List<SongListRespDto> {
        val collectionSong = collectionRepository.findCollectionSongById(
            collectionId,
            PageUtil.page(page, size)).get().toList()

        return collectionSong.map { SongListRespDto.from(it) }
    }

    fun createCollection(request: CollectionCreateReq): Long? {
        val collection = collectionRepository.save(
            CollectionEntity(
                name = request.name,
                description = request.description,
                orders = request.orders,
                isActive = request.isActive
            )
        )

        return collection.id
    }
}