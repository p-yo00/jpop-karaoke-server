package com.yeoff.jpopkaraokeserver.service

import com.yeoff.jpopkaraokeserver.domain.constant.SuccessCode
import com.yeoff.jpopkaraokeserver.domain.dto.SingerListRespDto
import com.yeoff.jpopkaraokeserver.domain.dto.SongListRespDto
import com.yeoff.jpopkaraokeserver.domain.dto.common.SuccessRespDto
import com.yeoff.jpopkaraokeserver.repository.SingerRepository
import com.yeoff.jpopkaraokeserver.repository.SongRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class SingerService(
    private val singerRepository: SingerRepository,
    private val songRepository: SongRepository
) {
    fun getSingerList(pageable: Pageable): SuccessRespDto<List<SingerListRespDto>> {
        val singerPage: List<SingerListRespDto> = singerRepository.findOrderBySongCount(pageable)

        return SuccessRespDto(
            successCode = SuccessCode.OK,
            data = singerPage
        )
    }

    fun getSingerSongList(singerId: Long, pageable: Pageable): SuccessRespDto<List<SongListRespDto>> {
        return SuccessRespDto(
            successCode = SuccessCode.OK,
            data = songRepository.findBySinger_Id(singerId, pageable)
                .map { SongListRespDto.from(it) }
        )
    }
}