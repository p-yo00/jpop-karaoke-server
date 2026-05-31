package com.yeoff.jpopkaraokeserver.domain.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "collection")
class CollectionEntity(

    var name: String? = null,

    var description: String? = null,

    var imageUrl: String? = null,

    var orders: Int? = null,

    var isActive: Boolean? = null
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    val createdAt: LocalDateTime = LocalDateTime.now()

    @OneToMany(
        cascade = [CascadeType.ALL],
        mappedBy = "collection",
        fetch = FetchType.LAZY)
    var collectionSongs: MutableList<CollectionSongEntity> = mutableListOf()


    fun addSong(song: SongEntity) {
        collectionSongs.add(
            CollectionSongEntity(collection = this, song = song))
    }
}