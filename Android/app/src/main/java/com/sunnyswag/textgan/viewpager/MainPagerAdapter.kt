package com.sunnyswag.textgan.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sunnyswag.textgan.fragment.FavoriteFragment
import com.sunnyswag.textgan.fragment.GenerateFragment

class MainPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    private val tabFragmentCreators = mapOf(
        FAVORITE_PAGER to { FavoriteFragment() },
        GENERATE_PAGER to { GenerateFragment() }
    )

    override fun getItemCount(): Int {
        return tabFragmentCreators.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabFragmentCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

    companion object {
        const val GENERATE_PAGER = 0
        const val FAVORITE_PAGER = 1
    }
}