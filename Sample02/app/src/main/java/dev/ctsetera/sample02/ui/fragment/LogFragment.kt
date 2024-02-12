package dev.ctsetera.sample02.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import dev.ctsetera.sample02.databinding.FragmentLogBinding

@AndroidEntryPoint
class LogFragment : Fragment() {

    private lateinit var binding: FragmentLogBinding

    private val viewModel: LogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // viewModel = ViewModelProvider(this)[LogViewModel::class.java]

        val listView = binding.listView

        viewModel.logList.observe(viewLifecycleOwner) { logList ->
            listView.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                logList
            )
        }

        viewModel.getAllLogs()
    }
}