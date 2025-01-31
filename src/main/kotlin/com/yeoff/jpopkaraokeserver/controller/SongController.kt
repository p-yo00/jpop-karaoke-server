package com.yeoff.jpopkaraokeserver.controller

import com.yeoff.jpopkaraokeserver.domain.dto.SongListRespDto
import com.yeoff.jpopkaraokeserver.service.SongService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SongController(val songService: SongService) {

    @GetMapping("/song/chart100")
    fun getJpopChart100(): ResponseEntity<List<SongListRespDto>> {
        return ResponseEntity.ok(songService.getJpopChart100())
    }
}