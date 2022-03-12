package az.layer.ui.features.home

import android.os.Bundle
import androidx.core.widget.NestedScrollView
import az.layer.ui.R
import az.layer.ui.base.BaseFragment
import az.layer.ui.databinding.FragmentHomeBinding
import az.layer.ui.extensions.changeStatusBarColor
import az.layer.ui.features.home.adapters.PostsAdapter
import az.layer.ui.features.home.models.Post


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

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

        setAdapter()
        initListeners()
    }

    private fun initViews() {


    }

    private fun initListeners() {
        initScrollViewListener()
    }

    private fun initScrollViewListener() {
        binding.scrollView.setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                if (scrollY > oldScrollY) {  //scroll down
                    //binding.toolbar.visibility = View.GONE
                } else if (scrollY < oldScrollY) {  //scroll up
                    //binding.toolbar.visibility = View.VISIBLE
                }
            })
    }


    private fun setAdapter() {
        val posts = arrayListOf<Post>()
        for (i in 0..50) {
            posts.add(Post("0"))
        }

        postsAdapter.setItems(posts)
        binding.postList.setHasFixedSize(true)
        binding.postList.adapter = postsAdapter
    }

}