package com.ramo.demosweetrecycler.databinding_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.ramo.demosweetrecycler.BR
import com.ramo.demosweetrecycler.MockService
import com.ramo.demosweetrecycler.MyModel
import com.ramo.demosweetrecycler.R
import com.ramo.demosweetrecycler.databinding.FragmentSweetRecyclerViewBinding
import com.ramo.demosweetrecycler.normal_fragment.UserViewHolder
import com.ramo.demosweetrecycler.viewbinding_fragment.VBProductViewHolder
import com.ramo.demosweetrecycler.viewbinding_fragment.VBUserViewHolder
import com.ramo.sweetrecycler.DBSweetViewHolder
import com.ramo.sweetrecycler.SweetViewHolder

class DataBindingFragment : Fragment() {

    private var _binding: FragmentSweetRecyclerViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSweetRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.sweetRecycler.render<MyModel> { viewGroup, position, data ->
            return@render if (data.isUser) DBUserViewHolder(viewGroup)
            else DBProductViewHolder(viewGroup)
        }

        binding.sweetRecycler.setOnItemClickListener<MyModel> { view, position, data ->
            Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_SHORT).show()
        }
        binding.sweetRecycler.setData(MockService.getMockList())
    }


}