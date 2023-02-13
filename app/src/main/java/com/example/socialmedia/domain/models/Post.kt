package com.example.socialmedia.domain.models

data class Post(
    val userName : String? = null,
    val description : String? = null,
    val likesCount : Int? = null,
    val commentsCount : Int? =  null,
    val imageUrl: String? = null,
    val profilePictureUrl: String? = null
)