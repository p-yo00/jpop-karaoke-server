package com.yeoff.jpopkaraokeserver.service

import com.yeoff.jpopkaraokeserver.domain.dto.SongDto
import com.yeoff.jpopkaraokeserver.domain.entity.SongEntity
import com.yeoff.jpopkaraokeserver.repository.SongRepository
import org.springframework.stereotype.Service

@Service
class SongService(private val songRepository: SongRepository) {

    fun getJpopChart100(): List<SongDto> {
        val list: ArrayList<SongDto> = ArrayList()

        for (songEntity: SongEntity in songRepository.findAll()) {
            println(songEntity)
            list.add(SongDto(
                id = songEntity.id,
                title = songEntity.title,
                singer = songEntity.singer,
                originalTitle = songEntity.originalTitle,
                lyrics = songEntity.lyrics,
                youtubeUrl = songEntity.youtubeUrl,
                albumImg = songEntity.albumImg,
                ky = songEntity.ky,
                tj = songEntity.tj,
                keyword = songEntity.keyword
            ))
        }

        return list
    }
}