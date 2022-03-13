package az.clone.linkedin.data.data_source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey val id: String?,
    val content: String?,
    val picture: String?,
    @ColumnInfo(name = "user_head_line")
    val userHeadline: String?,
    @ColumnInfo(name = "user_name")
    val userName: String?,
    @ColumnInfo(name = "user_profile_img")
    val userProfileImg: String?,
)