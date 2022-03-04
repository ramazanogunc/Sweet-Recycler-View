package com.ramo.demosweetrecycler.viewbinding_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ramo.demosweetrecycler.MockService
import com.ramo.demosweetrecycler.MyModel
import com.ramo.demosweetrecycler.databinding.FragmentSweetRecyclerViewBinding
import com.ramo.demosweetrecycler.databinding.ItemProductBinding
import com.ramo.demosweetrecycler.databinding.ItemUserBinding
import com.ramo.sweetrecycler.VBSweetViewHolder

class ViewBindingFragment : Fragment() {

    private var _binding: FragmentSweetRecyclerViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSweetRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecycler()
    }


    private fun setupRecycler() {
        binding.sweetRecycler.render<MyModel> { viewGroup, position, data ->
            //return@render if (data.isUser) getUserViewHolderVB(viewGroup)
            return@render if (data.isUser) VBUserViewHolder(viewGroup)
            else getProductViewHolderVB(viewGroup)
        }

        binding.sweetRecycler.setOnItemClickListener<MyModel> { view, position, data ->
            Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_SHORT).show()
        }
        binding.sweetRecycler.setData(MockService.getMockList())
    }

    private fun getUserViewHolderVB(viewGroup: ViewGroup): VBSweetViewHolder<ItemUserBinding, MyModel> {
        return VBSweetViewHolder(
            ItemUserBinding::inflate,
            viewGroup,
            onBindData = { binding, position, data ->
                binding.txtUsername.text = data.title
            },
        )
    }

    private fun getProductViewHolderVB(viewGroup: ViewGroup): VBSweetViewHolder<ItemProductBinding, MyModel> {
        return VBSweetViewHolder(
            ItemProductBinding::inflate,
            viewGroup,
            onBindData = { binding, position, data ->
                binding.txtProductName.text = data.title
            },
        )
    }


}