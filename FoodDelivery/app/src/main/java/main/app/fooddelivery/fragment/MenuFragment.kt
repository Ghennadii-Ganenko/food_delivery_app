package main.app.fooddelivery.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import main.app.fooddelivery.R
import main.app.fooddelivery.adapter.ProductAdapter
import main.app.fooddelivery.databinding.FragmentMenuBinding
import main.app.fooddelivery.domain.models.ProductEntity
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MenuFragment : Fragment(R.layout.fragment_menu), ProductAdapter.ItemClickListener {

    private var binding: FragmentMenuBinding? = null
    private val vm by viewModel<MenuViewModel>()
    private lateinit var adapter: ProductAdapter

    companion object {
        fun newInstance() = MenuFragment()
    }

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMenuBinding.inflate(inflater, container, false)
        this.binding = binding

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("Fragment created")
        adapter = ProductAdapter(this, requireContext(), view)

        binding?.productList?.layoutManager = LinearLayoutManager(requireContext())
        binding?.productList?.adapter = adapter

        vm.productList.observe(viewLifecycleOwner) { result ->
            adapter.submitList(result)
        }

        vm.getAllProductsList()
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("Fragment destroyed")
    }

    override fun onItemClicked(item: ProductEntity, view: View) {

    }

}