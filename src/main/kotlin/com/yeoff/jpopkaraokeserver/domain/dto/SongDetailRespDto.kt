package com.yeoff.jpopkaraokeserver.domain.dto

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
    class LyricsUnit(
        var kor: String?,
        var jpn: String?,
        var rom: String?
    )
}