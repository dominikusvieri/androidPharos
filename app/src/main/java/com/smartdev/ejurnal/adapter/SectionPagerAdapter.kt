package com.smartdev.ejurnal.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.smartdev.ejurnal.fragment.ListJurnalFragment
import com.smartdev.ejurnal.fragment.ListRequestFragment

class SectionPagerAdapter (activity: AppCompatActivity): FragmentStateAdapter(activity) {


    override fun createFragment(position: Int): Fragment {
        var fragment:Fragment? = null
        when (position){
            0 -> fragment = ListJurnalFragment()
            1 -> fragment = ListRequestFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}