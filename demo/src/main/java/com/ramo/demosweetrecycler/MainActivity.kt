package com.ramo.demosweetrecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.ramo.demosweetrecycler.databinding.ActivityMainBinding
import com.ramo.demosweetrecycler.databinding_fragment.DataBindingFragment
import com.ramo.demosweetrecycler.normal_fragment.NormalFragment
import com.ramo.demosweetrecycler.viewbinding_fragment.ViewBindingFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()

    }

    private fun setupViewPager() {
        val adapter = StandardFragmentStateAdapter(this)
        adapter.addFragment(NormalFragment(), "Normal")
        adapter.addFragment(ViewBindingFragment(), "ViewBinding")
        adapter.addFragment(DataBindingFragment(), "DataBinding")
        with(binding) {
            viewpager2.adapter = adapter
            TabLayoutMediator(tabLayout, viewpager2) { tab, position ->
                tab.text = adapter.getTitle(position)
            }.attach()
        }

    }

}

