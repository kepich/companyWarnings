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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.soft.companywarnings.viewmodels.CompanyWarningEditViewModel

@AndroidEntryPoint
class CompanyWarningEditFragment : Fragment() {

    companion object {
        const val NEW_WARNING_PARAMETER = -1
        fun newInstance() = CompanyWarningEditFragment()
    }

    val args: CompanyWarningEditFragmentArgs by navArgs()
    var textView: TextView? = null

    private val viewModel: CompanyWarningEditViewModel by viewModels()

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

        if (args.warningId != NEW_WARNING_PARAMETER) {
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.getWarningById(args.warningId).collect { companyWarning ->
                        textView?.text = companyWarning.toString()
                    }
                }
            }
        }
    }
}