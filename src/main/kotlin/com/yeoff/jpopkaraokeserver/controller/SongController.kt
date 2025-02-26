package com.yeoff.jpopkaraokeserver.controller

import com.yeoff.jpopkaraokeserver.domain.dto.SongDetailRespDto
import com.yeoff.jpopkaraokeserver.domain.dto.SongListRespDto
import com.yeoff.jpopkaraokeserver.domain.dto.common.SuccessRespDto
import com.yeoff.jpopkaraokeserver.service.SongService
import com.yeoff.jpopkaraokeserver.util.PageUtil
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SongController(val songService: SongService) {

    @GetMapping("/song/chart100")
    fun getJpopChart100(@RequestParam(required = false) page: Int?,
                        @RequestParam(required = false) size: Int?): ResponseEntity<SuccessRespDto<List<SongListRespDto>>> {
        return ResponseEntity.ok(songService.getJpopChart100(PageUtil.page(page, size)))
    }

    @GetMapping("/song/{songId}")
    fun getSongDetail(@PathVariable("songId") songId: Long): ResponseEntity<SuccessRespDto<SongDetailRespDto>> {
        return ResponseEntity.ok(songService.getSongDetail(songId))
    }

    @GetMapping("/song")
    fun getSongSearch(@RequestParam("q") query: String,
                      @RequestParam(required = false) page: Int?,
                      @RequestParam(required = false) size: Int?): ResponseEntity<SuccessRespDto<List<SongListRespDto>>> {
        return ResponseEntity.ok(songService.getSongSearch(query, PageUtil.page(page, size)))
    }
}