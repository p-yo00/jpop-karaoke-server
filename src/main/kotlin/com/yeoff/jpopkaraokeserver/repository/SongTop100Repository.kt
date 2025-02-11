package com.yeoff.jpopkaraokeserver.repository

import com.yeoff.jpopkaraokeserver.domain.entity.SongTop100Entity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SongTop100Repository : JpaRepository<SongTop100Entity, Long> {
}