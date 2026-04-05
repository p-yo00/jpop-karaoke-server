package com.yeoff.jpopkaraokeserver.repository

import com.yeoff.jpopkaraokeserver.domain.entity.SuggestionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SuggestionRepository : JpaRepository<SuggestionEntity, Long>