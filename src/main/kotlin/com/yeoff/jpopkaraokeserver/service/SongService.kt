package com.yeoff.jpopkaraokeserver.service

import com.yeoff.jpopkaraokeserver.domain.constant.FailCode
import com.yeoff.jpopkaraokeserver.domain.constant.JpopException
import com.yeoff.jpopkaraokeserver.domain.constant.SuccessCode
import com.yeoff.jpopkaraokeserver.domain.dto.SongDetailRespDto
import com.yeoff.jpopkaraokeserver.domain.dto.SongListRespDto
import com.yeoff.jpopkaraokeserver.domain.dto.SuccessRespDto
import com.yeoff.jpopkaraokeserver.domain.entity.LyricsEntity
import com.yeoff.jpopkaraokeserver.domain.entity.SongEntity
import com.yeoff.jpopkaraokeserver.repository.LyricsRepository
import com.yeoff.jpopkaraokeserver.repository.SongRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class SongService(
    private val songRepository: SongRepository,
    private val lyricsRepository: LyricsRepository
) {
    fun getJpopChart100(): SuccessRespDto<List<SongListRespDto>> {
        val list: ArrayList<SongListRespDto> = ArrayList()

        for (songEntity: SongEntity in songRepository.findAll()) {
            list.add(SongListRespDto(
                id = songEntity.id,
                title = songEntity.title,
                singer = songEntity.singer?.name,
                originalTitle = songEntity.originalTitle,
                albumImg = songEntity.albumImg,
                ky = songEntity.ky,
                tj = songEntity.tj
            ))
        }

        return SuccessRespDto(SuccessCode.OK, list)
    }

    fun getSongDetail(songId: Long): SuccessRespDto<SongDetailRespDto> {
        val songEntity: SongEntity? = songRepository.findById(songId).getOrNull()
        checkNotNull(songEntity) { throw JpopException(FailCode.SONG_NOT_FOUND) }

        val lyricsEntities: List<LyricsEntity> = lyricsRepository.findBySong_IdOrderBySequence(songId)
        val lyricsList: ArrayList<SongDetailRespDto.LyricsUnit> = ArrayList()
        for (lyricsEntity: LyricsEntity in lyricsEntities) {
            lyricsList.add(
                SongDetailRespDto.LyricsUnit(
                    kor = lyricsEntity.kor, jpn = lyricsEntity.jpn, rom = lyricsEntity.rom)
            )
        }

        return SuccessRespDto(SuccessCode.OK, SongDetailRespDto(
            id = songEntity.id,
            title = songEntity.title,
            singer = songEntity.singer?.name,
            originalTitle = songEntity.originalTitle,
            albumImg = songEntity.albumImg,
            youtubeUrl = songEntity.youtubeUrl,
            ky = songEntity.ky,
            tj = songEntity.tj,
            lyrics = lyricsList
        ))
    }
}