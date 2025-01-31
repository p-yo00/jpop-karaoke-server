package com.yeoff.jpopkaraokeserver.domain.constant

import org.springframework.http.HttpStatus

enum class FailCode(
    var code: String,
    var httpStatus: HttpStatus
) {
    SONG_NOT_FOUND("NOT_FOUND:SONG_DETAIL", HttpStatus.BAD_REQUEST)
}