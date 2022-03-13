package az.clone.linkedin.ui.features.home

import android.os.Bundle
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import az.clone.linkedin.R
import az.clone.linkedin.databinding.FragmentHomeBinding
import az.clone.linkedin.ui.base.BaseFragment
import az.clone.linkedin.ui.extensions.changeStatusBarColor
import az.clone.linkedin.ui.features.home.adapters.PostsAdapter
import az.clone.linkedin.ui.features.home.models.Post
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val homeViewModel: HomeViewModel by viewModels()

    private val postsAdapter: PostsAdapter by lazy {
        PostsAdapter { post ->
            showShortToast(post.id)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.applicationContext?.let {
            activity?.changeStatusBarColor(it, R.color.white)
        }
    }

    override fun initUi() {
        initObservers()
        initViews()
        initListeners()
        homeViewModel.getPosts()
    }

    private fun initObservers() {
        homeViewModel.posts.observe(viewLifecycleOwner) { posts ->
            postsAdapter.setItems(posts)
            binding.postList.adapter = postsAdapter
        }
    }

    private fun initViews() {
    }

    private fun initListeners() {
        binding.scrollView.setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                if (scrollY > oldScrollY) {  //scroll down
                    //binding.toolbar.visibility = View.GONE
                } else if (scrollY < oldScrollY) {  //scroll up
                    //binding.toolbar.visibility = View.VISIBLE
                }
            })
    }
}