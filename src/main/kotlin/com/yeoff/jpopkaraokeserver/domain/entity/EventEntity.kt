package com.yeoff.jpopkaraokeserver.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "event")
class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var eventType: String? = null

    var payload: String? = null

    val eventDateTime: LocalDateTime = LocalDateTime.now()


    companion object {
        fun create(eventType: String, payload: String): EventEntity {
            val event = EventEntity()
            event.eventType = eventType
            event.payload = payload

            return event
        }
    }
}