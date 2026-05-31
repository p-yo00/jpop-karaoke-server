package com.yeoff.jpopkaraokeserver.controller

import com.yeoff.jpopkaraokeserver.domain.constant.SuccessCode
import com.yeoff.jpopkaraokeserver.domain.dto.CollectionCreateReq
import com.yeoff.jpopkaraokeserver.domain.dto.CollectionListResp
import com.yeoff.jpopkaraokeserver.domain.dto.SongListRespDto
import com.yeoff.jpopkaraokeserver.domain.dto.common.SuccessRespDto
import com.yeoff.jpopkaraokeserver.service.CollectionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CollectionController(val collectionService: CollectionService) {

    @PostMapping("/collections")
    fun createCollection(request: CollectionCreateReq): ResponseEntity<SuccessRespDto<Long>> {
        return ResponseEntity.ok(
            SuccessRespDto(
                successCode = SuccessCode.CREATED,
                data = collectionService.createCollection(request)
            )
        )
    }

    @GetMapping("/collections")
    fun getCollections()
            : ResponseEntity<SuccessRespDto<List<CollectionListResp>>> {
        return ResponseEntity.ok(
            SuccessRespDto(
                successCode = SuccessCode.OK,
                data = collectionService.getCollections()
            )
        )
    }

    @GetMapping("/collections/{collectionId}")
    fun getCollectionSong(
        @PathVariable collectionId: Long,
        @RequestParam(required = false) page: Int?,
        @RequestParam(required = false) size: Int?
    ): ResponseEntity<SuccessRespDto<List<SongListRespDto>>> {
        return ResponseEntity.ok(
            SuccessRespDto(
                successCode = SuccessCode.OK,
                data = collectionService.getCollectionSong(
                    collectionId,
                    page,
                    size
                )
            )
        )
    }
}