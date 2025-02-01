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
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class SongService(
    @Value("\${IMAGE_SERVER}")
    private val imageServerDomain: String,
    private val songRepository: SongRepository,
    private val lyricsRepository: LyricsRepository
) {
    fun getJpopChart100(): SuccessRespDto<List<SongListRespDto>> {
        return SuccessRespDto(
            successCode = SuccessCode.OK,
            data = songRepository.findAll()
                .map {
                    SongListRespDto(
                        id = it.id,
                        title = it.title,
                        singer = it.singer?.name,
                        originalTitle = it.originalTitle,
                        albumImg = imageServerDomain + it.albumImg,
                        ky = it.ky,
                        tj = it.tj
                    )
                }
        )
    }

    fun getSongDetail(songId: Long): SuccessRespDto<SongDetailRespDto> {
        val songEntity: SongEntity? = songRepository.findById(songId).getOrNull()
        checkNotNull(songEntity) { throw JpopException(FailCode.SONG_NOT_FOUND) }

        val lyricsList: List<SongDetailRespDto.LyricsUnit> =
            lyricsRepository.findBySong_IdOrderBySequence(songId)
                .map {
                    SongDetailRespDto.LyricsUnit(
                        kor = it.kor,
                        jpn = it.jpn,
                        rom = it.rom
                    )
                }

        return SuccessRespDto(
            successCode = SuccessCode.OK,
            data = SongDetailRespDto(
                id = songEntity.id,
                title = songEntity.title,
                singer = songEntity.singer?.name,
                originalTitle = songEntity.originalTitle,
                albumImg = imageServerDomain + songEntity.albumImg,
                youtubeUrl = songEntity.youtubeUrl,
                ky = songEntity.ky,
                tj = songEntity.tj,
                lyrics = lyricsList
            )
        )
    }
}