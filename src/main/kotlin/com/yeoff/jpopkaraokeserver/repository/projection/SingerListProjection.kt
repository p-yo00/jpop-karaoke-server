package com.yeoff.jpopkaraokeserver.repository.projection

interface SingerListProjection {

    fun getId(): Long
    fun getName(): String
    fun getOriginalName(): String?
    fun getProfileImg(): String?
    fun getSongCount(): Long
}