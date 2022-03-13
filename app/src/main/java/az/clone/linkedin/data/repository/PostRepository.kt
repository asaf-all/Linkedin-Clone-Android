package az.clone.linkedin.data.repository

import az.clone.linkedin.data.data_source.remote.services.PostApi
import az.clone.linkedin.data.repository.mapper.PostMapper
import az.clone.linkedin.ui.features.home.models.Post
import com.google.gson.JsonSyntaxException
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val apiService: PostApi,
    private val mapper: PostMapper
) {

    suspend fun getPosts(): List<Post> {
        return try {
            apiService.getPosts().body()?.let {
                mapper.toPostsDomainModel(it)
            } ?: emptyList()

        } catch (e: JsonSyntaxException) { throw e }
    }

}