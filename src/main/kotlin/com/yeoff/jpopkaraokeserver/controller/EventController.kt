package com.yeoff.jpopkaraokeserver.controller

import com.yeoff.jpopkaraokeserver.domain.dto.common.SuccessRespDto
import com.yeoff.jpopkaraokeserver.service.EventService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController(val eventService: EventService) {

    class EventReq(val eventType: String, val payload: Any)

    @PostMapping("/event")
    fun saveEvent(@RequestBody request: EventReq)
            : ResponseEntity<SuccessRespDto<Void>> {
        eventService.issueEvent(request.eventType, request.payload)

        return ResponseEntity.ok(null)
    }
}