package az.clone.linkedin.data.data_source.remote.services

import az.clone.linkedin.data.data_source.remote.dto.PostResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface PostApi {

    @GET("iamasaf-profile/Linkedin-Clone-Android/master/api/posts.txt")
    suspend fun getPosts(): Response<PostResponse>

}