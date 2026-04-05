package com.yeoff.jpopkaraokeserver.service

import com.yeoff.jpopkaraokeserver.domain.entity.SuggestionEntity
import com.yeoff.jpopkaraokeserver.repository.SuggestionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SuggestionService(val suggestionRepository: SuggestionRepository) {

    @Transactional
    fun sendSuggestion(content: String) {
        val entity = SuggestionEntity.create(content)
        suggestionRepository.save(entity)
    }
}