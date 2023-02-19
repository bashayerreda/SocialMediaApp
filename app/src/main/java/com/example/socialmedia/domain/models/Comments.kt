package com.example.socialmedia.domain.models

import java.util.*

data class Comments(val commentId : Int? = -1,
                    val profileImage : String? = "",
                    val userName : String? =  "",
                    val timestamp: Long = System.currentTimeMillis(),
                    var likesCount : Int = 16,
                    val isLiked : Boolean = false,
                    val comment : String? = "",


                    )