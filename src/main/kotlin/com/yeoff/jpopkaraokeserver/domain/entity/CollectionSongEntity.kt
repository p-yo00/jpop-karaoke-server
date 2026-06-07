package com.yeoff.jpopkaraokeserver.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "collection_song")
class CollectionSongEntity(

    @ManyToOne
    var collection: CollectionEntity? = null,

    @ManyToOne
    var song: SongEntity? = null,

    var orders: Int? = null,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}