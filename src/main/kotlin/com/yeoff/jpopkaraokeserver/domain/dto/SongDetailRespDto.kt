package com.yeoff.jpopkaraokeserver.domain.dto

import com.yeoff.jpopkaraokeserver.domain.entity.LyricsEntity
import com.yeoff.jpopkaraokeserver.domain.entity.SongEntity
import com.yeoff.jpopkaraokeserver.util.FileUtil

class SongDetailRespDto(
    var id: Long?,
    var title: String?,
    var originalTitle: String?,
    var singer: String?,
    var youtubeUrl: String?,
    var albumImg: String?,
    var ky: Int?,
    var tj: Int?,
    var lyrics: List<LyricsUnit>?
) {
    companion object {
        fun of(songEntity: SongEntity, lyricsEntityList: List<LyricsEntity>): SongDetailRespDto {
            return SongDetailRespDto(
                id = songEntity.id,
                title = songEntity.title,
                singer = songEntity.singer?.name,
                originalTitle = songEntity.originalTitle,
                albumImg = FileUtil.getImageUrl(songEntity.albumImg),
                youtubeUrl = songEntity.youtubeUrl,
                ky = songEntity.ky,
                tj = songEntity.tj,
                lyrics = lyricsEntityList.map {
                    LyricsUnit(
                        kor = it.kor,
                        jpn = it.jpn,
                        rom = it.rom
                    )
                }
            )
        }
    }

    class LyricsUnit(
        var kor: String?,
        var jpn: String?,
        var rom: String?
    )
}