package ru.soft.companywarnings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class WarningsListFragment : Fragment() {

    companion object {
        fun newInstance() = WarningsListFragment()
    }

    private val viewModel: WarningsListViewModel by viewModels()
    private var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listView?.onItemClickListener =
            AdapterView.OnItemClickListener { _: AdapterView<*>?, _: View?, position: Int, _: Long ->
                findNavController().navigate(
                    WarningsListFragmentDirections.actionWarningsListFragmentToCompanyWarningEditFragment(
//                        listView!!.getItemAtPosition(position) as String
//                        position
//                        5
                    )
                )
            }

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_warnings_list, container, false).also {
            listView = it.findViewById(R.id.listView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getWarningList().collect { companyWarnings ->
                    listView?.adapter = ArrayAdapter(
                        requireContext(), R.layout.list_item,
                        companyWarnings.map { it.toString() }
                    )
                }
            }
        }
    }
}