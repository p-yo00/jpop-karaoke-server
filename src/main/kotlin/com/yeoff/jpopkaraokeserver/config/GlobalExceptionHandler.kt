package com.yeoff.jpopkaraokeserver.config

import com.yeoff.jpopkaraokeserver.domain.constant.JpopException
import com.yeoff.jpopkaraokeserver.domain.dto.common.FailRespDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(JpopException::class)
    fun handleJpopException(e: JpopException): ResponseEntity<FailRespDto> {
        return ResponseEntity(FailRespDto(e.failCode), e.failCode.httpStatus)
    }
}