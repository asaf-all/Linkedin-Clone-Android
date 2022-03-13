package az.clone.linkedin.data.repository.mapper

import az.clone.linkedin.data.data_source.remote.dto.PostResponse
import az.clone.linkedin.ui.features.home.models.Post
import javax.inject.Inject


class PostMapper @Inject constructor() {

    fun toPostsDomainModel(postsDto: PostResponse): List<Post>? {
        return postsDto.posts?.map { post ->
            post.toPostDomainModel()
        }
    }

    private fun PostResponse.Post.toPostDomainModel(): Post {
        return Post(
            id = this.id,
            content = this.content,
            picture = this.picture,
            userHeadline = this.user?.headline,
            userName = this.user?.name,
            userProfileImg = this.user?.profileImg
        )
    }
}