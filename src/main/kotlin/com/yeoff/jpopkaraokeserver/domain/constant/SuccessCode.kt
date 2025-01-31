package com.yeoff.jpopkaraokeserver.domain.constant

import org.springframework.http.HttpStatus

enum class SuccessCode(
    var code: String,
    var httpStatus: HttpStatus
) {
    OK("OK", HttpStatus.OK)
}