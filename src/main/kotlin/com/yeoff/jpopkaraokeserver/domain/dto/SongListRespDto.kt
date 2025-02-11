package com.yeoff.jpopkaraokeserver.domain.dto

import com.yeoff.jpopkaraokeserver.domain.entity.SongEntity
import com.yeoff.jpopkaraokeserver.domain.entity.SongTop100Entity
import com.yeoff.jpopkaraokeserver.util.FileUtil

class SongListRespDto(
    var id: Long?,
    var title: String?,
    var originalTitle: String?,
    var singer: String?,
    var albumImg: String?,
    var ky: Int?,
    var tj: Int?
) {

    companion object {
        fun from(songEntity: SongEntity): SongListRespDto {
            return SongListRespDto(
                id = songEntity.id,
                title = songEntity.title,
                singer = songEntity.singer?.name,
                originalTitle = songEntity.originalTitle,
                albumImg =  FileUtil.getImageUrl(songEntity.albumImg),
                ky = songEntity.ky,
                tj = songEntity.tj
            )
        }
        fun from(songEntity: SongTop100Entity): SongListRespDto {
            return SongListRespDto(
                id = songEntity.id,
                title = songEntity.title,
                singer = songEntity.singer?.name,
                originalTitle = songEntity.originalTitle,
                albumImg =  FileUtil.getImageUrl(songEntity.albumImg),
                ky = songEntity.ky,
                tj = songEntity.tj
            )
        }
    }
}