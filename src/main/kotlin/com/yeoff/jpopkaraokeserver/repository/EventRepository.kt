package com.yeoff.jpopkaraokeserver.repository

import com.yeoff.jpopkaraokeserver.domain.entity.EventEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository : JpaRepository<EventEntity, Long>