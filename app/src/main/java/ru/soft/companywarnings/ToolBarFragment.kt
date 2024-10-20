package ru.soft.companywarnings

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.soft.companywarnings.CompanyWarningEditFragment.Companion.NEW_WARNING_PARAMETER

@AndroidEntryPoint
class ToolBarFragment : Fragment() {
    private lateinit var checkNetworkConnection: CheckNetworkConnection

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tool_bar, container, false).also {
            it.findViewById<Button>(R.id.newButton).setOnClickListener {
                findNavController().navigate(
                    WarningsListFragmentDirections.actionWarningsListFragmentToCompanyWarningEditFragment(
                        NEW_WARNING_PARAMETER
                    )
                )
            }
            callNetworkConnection(it.findViewById(R.id.syncButton))
        }
    }

    private fun callNetworkConnection(button: Button) {
        val connectivityManager: ConnectivityManager? =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager?.also {
            checkNetworkConnection = CheckNetworkConnection(it)
            checkNetworkConnection.observe(viewLifecycleOwner) { isConnected ->
                button.setEnabled(isConnected)
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = ToolBarFragment()
    }
}