package com.yeoff.jpopkaraokeserver.util

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

class PageUtil {
    companion object {
        fun page(page: Int?, size: Int?): Pageable {
            return if (page == null  || size == null) {
                Pageable.unpaged()
            } else {
                PageRequest.of(page, size)
            }
        }
    }
}