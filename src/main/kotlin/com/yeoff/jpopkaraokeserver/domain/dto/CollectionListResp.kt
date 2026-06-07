package com.yeoff.jpopkaraokeserver.domain.dto

import com.yeoff.jpopkaraokeserver.domain.entity.CollectionEntity

class CollectionListResp(
    val id: Long?,
    var name: String?,
    var description: String?,
    var imageUrl: String?,
    var orders: Int?
) {
    companion object {
        fun from(entity: CollectionEntity): CollectionListResp {
            return CollectionListResp(
                entity.id,
                entity.name,
                entity.description,
                entity.imageUrl,
                entity.orders
            )
        }
    }
}