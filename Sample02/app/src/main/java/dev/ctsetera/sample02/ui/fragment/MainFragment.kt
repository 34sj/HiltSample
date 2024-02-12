package dev.ctsetera.sample02.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.ctsetera.sample02.databinding.FragmentMainBinding
@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel  by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button1 = binding.button1
        val button2 = binding.button2
        val button3 = binding.button3
        val buttonShowLog = binding.buttonShowLog
        val buttonDeleteLog = binding.buttonDeleteLog

        button1.setOnClickListener {
            viewModel.addLog("Interaction with 'Button 1'")
        }

        button2.setOnClickListener {
            viewModel.addLog("Interaction with 'Button 2'")
        }

        button3.setOnClickListener {
            viewModel.addLog("Interaction with 'Button 3'")
        }

        buttonShowLog.setOnClickListener {
            requireView().findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToLogFragment())
        }

        buttonDeleteLog.setOnClickListener {
            viewModel.deleteLogs()
        }
    }
}