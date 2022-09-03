package com.sunnyswag.textgan.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.sunnyswag.textgan.R
import com.sunnyswag.textgan.databinding.FragmentViewPagerBinding
import com.sunnyswag.textgan.viewpager.MainPagerAdapter

class HomeViewPagerFragment: Fragment() {

    lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewpager.apply {
            adapter = MainPagerAdapter(this@HomeViewPagerFragment)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    if (position == MainPagerAdapter.GENERATE_PAGER) {
                        binding.bottomNav.selectedItemId = R.id.page1
                    } else if (position == MainPagerAdapter.FAVORITE_PAGER) {
                        binding.bottomNav.selectedItemId = R.id.page2
                    }
                }
            })
        }

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page1 -> {
                    binding.viewpager.currentItem = MainPagerAdapter.GENERATE_PAGER
                    true
                }
                R.id.page2 -> {
                    binding.viewpager.currentItem = MainPagerAdapter.FAVORITE_PAGER
                    true
                }
                else -> false
            }
        }
    }
}