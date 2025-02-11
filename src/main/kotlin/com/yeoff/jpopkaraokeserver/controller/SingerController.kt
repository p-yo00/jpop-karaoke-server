package com.yeoff.jpopkaraokeserver.controller

import com.yeoff.jpopkaraokeserver.domain.dto.SingerListRespDto
import com.yeoff.jpopkaraokeserver.domain.dto.SongListRespDto
import com.yeoff.jpopkaraokeserver.domain.dto.common.SuccessRespDto
import com.yeoff.jpopkaraokeserver.service.SingerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SingerController(val singerService: SingerService) {

    @GetMapping("/singer")
    fun getSingerList(pageable: Pageable): ResponseEntity<SuccessRespDto<Page<SingerListRespDto>>> {
        return ResponseEntity.ok(singerService.getSingerList(pageable))
    }

    @GetMapping("/singer/{singerId}/song")
    fun getSingerSongList(@PathVariable("singerId") singerId: Long,
                          pageable: Pageable
    ): ResponseEntity<SuccessRespDto<Page<SongListRespDto>>>
    {
        return ResponseEntity.ok(singerService.getSingerSongList(singerId, pageable))
    }
}