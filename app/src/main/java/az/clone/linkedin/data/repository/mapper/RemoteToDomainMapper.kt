package az.clone.linkedin.data.repository.mapper

import az.clone.linkedin.data.data_source.remote.dto.PostDto
import az.clone.linkedin.ui.features.home.models.Post

fun PostDto.Post.toDomain(): Post {
    return Post(
        id = this.id,
        content = this.content,
        picture = this.picture,
        userHeadline = this.user?.headline,
        userName = this.user?.name,
        userProfileImg = this.user?.profileImg
    )
}