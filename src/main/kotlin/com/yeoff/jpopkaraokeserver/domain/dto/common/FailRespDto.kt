package com.yeoff.jpopkaraokeserver.domain.dto.common

import com.yeoff.jpopkaraokeserver.domain.constant.FailCode

class FailRespDto(
    failCode: FailCode
) {
    var code: String = failCode.code
}