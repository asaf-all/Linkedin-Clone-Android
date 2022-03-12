package az.layer.ui.features.splash

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import az.layer.ui.R
import az.layer.ui.base.BaseFragment
import az.layer.ui.databinding.FragmentSplashBinding
import az.layer.ui.extensions.changeStatusBarColor
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
            delay(1500)
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }


    }
}