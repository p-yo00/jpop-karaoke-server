package com.yeoff.jpopkaraokeserver.service

import com.yeoff.jpopkaraokeserver.domain.dto.SongListRespDto
import com.yeoff.jpopkaraokeserver.domain.entity.SongEntity
import com.yeoff.jpopkaraokeserver.repository.SongRepository
import org.springframework.stereotype.Service

@Service
class SongService(private val songRepository: SongRepository) {

    fun getJpopChart100(): List<SongListRespDto> {
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

        return list
    }
}