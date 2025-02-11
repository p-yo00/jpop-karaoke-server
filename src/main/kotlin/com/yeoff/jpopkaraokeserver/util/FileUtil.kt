package com.yeoff.jpopkaraokeserver.util

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class FileUtil {
    companion object {
        @Value("\${IMAGE_SERVER}")
        private val imageServerDomain: String = ""

        fun getImageUrl(filePath: String?): String {
            checkNotNull(filePath) { return "" }
            return imageServerDomain + filePath
        }
    }
}