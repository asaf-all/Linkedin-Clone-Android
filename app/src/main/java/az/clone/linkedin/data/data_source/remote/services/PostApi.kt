package az.clone.linkedin.data.data_source.remote.services

import az.clone.linkedin.data.data_source.remote.dto.PostDto
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {

    @GET("iamasaf-profile/Linkedin-Clone-Android/master/api/posts.txt")
    suspend fun getPosts(): Response<PostDto>

}