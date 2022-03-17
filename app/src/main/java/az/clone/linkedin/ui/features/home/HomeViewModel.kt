package az.clone.linkedin.ui.features.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import az.clone.linkedin.data.repository.PostRepository
import az.clone.linkedin.ui.features.home.models.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    private val postRepository: PostRepository,
) : AndroidViewModel(application) {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    private val _postsIsLoading = MutableLiveData<Boolean>()
    val postsIsLoading: LiveData<Boolean> get() = _postsIsLoading

    fun getPosts() {
        _postsIsLoading.value = true
        CoroutineScope(Dispatchers.IO).launch {
            _posts.postValue(postRepository.getPosts())
        }
    }



}