package ru.soft.companywarnings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.launch
import ru.soft.companywarnings.viewmodels.CompanyWarningEditViewModel

class CompanyWarningEditFragment : Fragment() {

    companion object {
        fun newInstance() = CompanyWarningEditFragment()
    }

    val args: CompanyWarningEditFragmentArgs by navArgs()
    var textView: TextView? = null

    private val viewModel: CompanyWarningEditViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_company_warning_edit, container, false).also {
            textView = it.findViewById(R.id.warningIdTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getWarningById(args.warningId).collect { companyWarning ->
                    textView?.text = companyWarning.toString()
                }
            }
        }
    }
}