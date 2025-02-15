package com.yeoff.jpopkaraokeserver.service

import com.yeoff.jpopkaraokeserver.domain.constant.SuccessCode
import com.yeoff.jpopkaraokeserver.domain.dto.SingerListRespDto
import com.yeoff.jpopkaraokeserver.domain.dto.SongListRespDto
import com.yeoff.jpopkaraokeserver.domain.dto.common.SuccessRespDto
import com.yeoff.jpopkaraokeserver.domain.entity.SingerEntity
import com.yeoff.jpopkaraokeserver.repository.SingerRepository
import com.yeoff.jpopkaraokeserver.repository.SongRepository
import org.springframework.stereotype.Service

@Service
class SingerService(
    private val singerRepository: SingerRepository,
    private val songRepository: SongRepository
) {
    fun getSingerList(): SuccessRespDto<List<SingerListRespDto>> {
        val singerPage: List<SingerEntity> = singerRepository.findOrderBySongCount()

        return SuccessRespDto(
            successCode = SuccessCode.OK,
            data = singerPage
                .filter { it.name != null }
                .map { SingerListRespDto.from(it) }
                .toList()
        )
    }

    fun getSingerSongList(singerId: Long): SuccessRespDto<List<SongListRespDto>> {
        return SuccessRespDto(
            successCode = SuccessCode.OK,
            data = songRepository.findBySinger_Id(singerId)
                .map { SongListRespDto.from(it) }
        )
    }
}