package com.example.kopashop.view.active_archive

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kopashop.view.favourites.ThirdFragment
import com.example.kopashop.view.list.FirstFragment

@Suppress("DEPRECATION")
class ArchiveAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            1 -> {
                ThirdFragment()
            }
            else -> getItem(position)
        }
    }
}


