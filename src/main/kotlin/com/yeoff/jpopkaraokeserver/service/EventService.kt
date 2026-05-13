package com.yeoff.jpopkaraokeserver.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.yeoff.jpopkaraokeserver.domain.constant.EventType
import com.yeoff.jpopkaraokeserver.domain.entity.EventEntity
import com.yeoff.jpopkaraokeserver.domain.entity.SongEntity
import com.yeoff.jpopkaraokeserver.repository.EventRepository
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class EventService(
    val eventRepository: EventRepository,
    val objectMapper: ObjectMapper
) {

    fun issueEvent(eventType: String, payload: Any) {
        val event = EventEntity.create(eventType,
            objectMapper.writeValueAsString(payload))
        eventRepository.save(event)
    }

    @Async(value = "asyncExecutor")
    fun issueEvent(keyword: String, songs: List<SongEntity>) {
        val payload = SearchData(
            keyword,
            songs.size,
            songs.mapNotNull { it.id }
        )

        issueEvent(
            EventType.SEARCH.name,
            payload)
    }

    data class SearchData(val keyword: String, val size: Int, val songIds: List<Long>)
}