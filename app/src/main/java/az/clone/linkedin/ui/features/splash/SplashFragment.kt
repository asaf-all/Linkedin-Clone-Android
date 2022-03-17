package az.clone.linkedin.ui.features.splash

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import az.clone.linkedin.R
import az.clone.linkedin.databinding.FragmentSplashBinding
import az.clone.linkedin.ui.base.BaseFragment
import az.clone.linkedin.ui.extensions.changeStatusBarColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.applicationContext?.let {
            activity?.changeStatusBarColor(it, R.color.linkedin_blue)
        }

    }

    override fun initUi() {

        lifecycleScope.launch {
            delay(500)
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }

    }


}