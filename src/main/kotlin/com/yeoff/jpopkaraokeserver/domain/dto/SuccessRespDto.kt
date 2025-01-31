package com.yeoff.jpopkaraokeserver.domain.dto

import com.yeoff.jpopkaraokeserver.domain.constant.SuccessCode

class SuccessRespDto<T>(
    successCode: SuccessCode,
    var data: T
) {
    var code: String = successCode.code
}