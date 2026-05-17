package com.yeoff.jpopkaraokeserver.domain.dto

import com.yeoff.jpopkaraokeserver.repository.projection.SingerListProjection
import com.yeoff.jpopkaraokeserver.util.FileUtil

class SingerListRespDto(
    val id: Long,
    var name: String,
    var originalName: String?,
    var profileImg: String?,
    var songCount: Int?
) {
    companion object {
        fun from(projection: SingerListProjection): SingerListRespDto {
            return SingerListRespDto(
                id = projection.getId(),
                name = projection.getName(),
                originalName = projection.getOriginalName(),
                profileImg = FileUtil.getImageUrl(projection.getProfileImg()),
                songCount = projection.getSongCount().toInt()
            )
        }
    }
}