package com.yeoff.jpopkaraokeserver.domain.dto

import com.yeoff.jpopkaraokeserver.domain.entity.SingerEntity
import com.yeoff.jpopkaraokeserver.util.FileUtil

class SingerListRespDto(
    val id: Long,
    var name: String,
    var originalName: String?,
    var profileImg: String?,
) {
    companion object {
        fun from(singerEntity: SingerEntity): SingerListRespDto {
            return SingerListRespDto(
                id = singerEntity.id,
                name = singerEntity.name!!,
                originalName = singerEntity.originalName,
                profileImg = FileUtil.getImageUrl(singerEntity.profileImg)
            )
        }
    }
}