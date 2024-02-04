package dev.ctsetera.sample01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.ctsetera.sample01.databinding.FragmentLogBinding

class LogFragment : Fragment() {

    private lateinit var binding: FragmentLogBinding

    private lateinit var viewModel: LogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[LogViewModel::class.java]

        val buttonBack = binding.buttonBack

        buttonBack.setOnClickListener {
            parentFragment?.childFragmentManager?.popBackStack()
        }
    }
}