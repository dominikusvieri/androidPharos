package com.smartdev.ejurnal.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.adapter.SectionPagerAdapter

class JurnalMainActivity : AppCompatActivity(){
    private lateinit var tvJudul:TextView
    private lateinit var tvDesc:TextView

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.content_tab_listJurnal,
            R.string.content_tab_listRequest
        )
    }

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvJudul = findViewById(R.id.tvJudul)
        tvDesc = findViewById(R.id.tvDesc)

        if (intent.extras != null){
            val bundle = intent.extras
            tvJudul.setText(bundle!!.getString("judul"))
            tvDesc.setText(bundle!!.getString("desc"))
            Log.d("BISA", tvJudul.text.toString() + tvDesc.text.toString())
        }

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val sectionPagerAdapter = SectionPagerAdapter(this)
        val viewPager : ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionPagerAdapter
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu1 ->{
                val i = Intent(this, RequestJurnalActivity::class.java)
                startActivity(i)
                return true
            }
            else -> return true
        }
    }

}