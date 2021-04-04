package sk.styk.martin.apkanalyzer.ui.permission.detail.pager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import sk.styk.martin.apkanalyzer.databinding.FragmentPermissionDetailBinding
import sk.styk.martin.apkanalyzer.model.permissions.LocalPermissionData
import sk.styk.martin.apkanalyzer.util.components.toDialog
import sk.styk.martin.apkanalyzer.util.provideViewModel
import javax.inject.Inject

class PermissionDetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: PermissionDetailFragmentViewModel.Factory

    private lateinit var binding: FragmentPermissionDetailBinding

    private lateinit var viewModel: PermissionDetailFragmentViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = provideViewModel { viewModelFactory.create(requireNotNull(requireArguments().getParcelable(ARG_PERMISSIONS_DATA))) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPermissionDetailBinding.inflate(inflater, container, false)
        binding.pager.adapter = PermissionDetailPagerAdapter(requireContext().applicationContext, childFragmentManager)
        binding.tabs.setupWithViewPager(binding.pager)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

        with(viewModel) {
            showDialog.observe(viewLifecycleOwner, { it.toDialog().show(parentFragmentManager, "PermissionDescription") })
            close.observe(viewLifecycleOwner, { requireActivity().onBackPressed() })
        }
    }

    companion object {

        val TAG = PermissionDetailFragment::class.java.simpleName

        const val ARG_PERMISSIONS_DATA = "permission_args"
        const val ARG_CHILD = "permission_args_to_my_sweetest_child"

        fun create(permissionData: LocalPermissionData) = PermissionDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_PERMISSIONS_DATA, permissionData)
            }
        }
    }
}
