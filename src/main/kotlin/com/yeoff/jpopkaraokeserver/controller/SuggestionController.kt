package com.yeoff.jpopkaraokeserver.controller

import com.yeoff.jpopkaraokeserver.domain.dto.common.SuccessRespDto
import com.yeoff.jpopkaraokeserver.service.SuggestionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SuggestionController(val suggestionService: SuggestionService) {

    class SuggestionReq(val content: String)

    @PostMapping("/suggestion")
    fun sendSuggestion(@RequestBody request: SuggestionReq)
    : ResponseEntity<SuccessRespDto<Void>> {
        suggestionService.sendSuggestion(request.content)

        return ResponseEntity.ok(null)
    }
}