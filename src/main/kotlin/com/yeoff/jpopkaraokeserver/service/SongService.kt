package com.yeoff.jpopkaraokeserver.service

import com.yeoff.jpopkaraokeserver.domain.constant.FailCode
import com.yeoff.jpopkaraokeserver.domain.constant.JpopException
import com.yeoff.jpopkaraokeserver.domain.constant.SuccessCode
import com.yeoff.jpopkaraokeserver.domain.dto.SongDetailRespDto
import com.yeoff.jpopkaraokeserver.domain.dto.SongListRespDto
import com.yeoff.jpopkaraokeserver.domain.dto.common.SuccessRespDto
import com.yeoff.jpopkaraokeserver.domain.entity.SongEntity
import com.yeoff.jpopkaraokeserver.repository.LyricsRepository
import com.yeoff.jpopkaraokeserver.repository.SongRepository
import com.yeoff.jpopkaraokeserver.repository.SongTop100Repository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class SongService(
    private val songRepository: SongRepository,
    private val lyricsRepository: LyricsRepository,
    private val songTop100Repository: SongTop100Repository
) {
    fun getJpopChart100(pageable: Pageable): SuccessRespDto<List<SongListRespDto>> {
        return SuccessRespDto(
            successCode = SuccessCode.OK,
            data = songTop100Repository.findTop100(pageable).map { SongListRespDto.from(it) }
        )
    }

    fun getSongDetail(songId: Long): SuccessRespDto<SongDetailRespDto> {
        val songEntity: SongEntity? = songRepository.findById(songId).getOrNull()
        checkNotNull(songEntity) { throw JpopException(FailCode.SONG_NOT_FOUND) }

        return SuccessRespDto(
            successCode = SuccessCode.OK,
            data = SongDetailRespDto.of(
                songEntity,
                lyricsEntityList = lyricsRepository.findBySong_IdOrderBySequence(songId)
            )
        )
    }

    fun getSongSearch(keyword: String, pageable: Pageable): SuccessRespDto<List<SongListRespDto>>? {
        return SuccessRespDto(
            successCode = SuccessCode.OK,
            data = songRepository.findByKeyword(keyword, pageable)
                .map { SongListRespDto.from(it) }
        )
    }
}