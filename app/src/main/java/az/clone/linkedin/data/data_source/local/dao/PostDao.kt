package az.clone.linkedin.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import az.clone.linkedin.data.data_source.local.entity.Post

@Dao
interface PostDao {

    @Insert
    fun insertData()

    @Query("SELECT * FROM posts")
    fun getPosts(): List<Post>
}