package com.example.storage.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookmarkProperty(
    @PrimaryKey val id: String,
)