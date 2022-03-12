package az.layer.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding : ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater) -> Binding
) : Fragment() {

    private var _binding: Binding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater.invoke(inflater)
        return binding.root
    }

    abstract fun initUi()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    protected fun showShortToast(text: String?) {
        Toast.makeText(requireContext(), text ?: "error!", Toast.LENGTH_SHORT).show()
    }

    protected fun showLongToast(text: String?) {
        Toast.makeText(requireContext(), text ?: "error!", Toast.LENGTH_LONG).show()
    }
}