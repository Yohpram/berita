package com.walwiyo.berita.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.walwiyo.berita.R
import com.walwiyo.berita.fragment.*
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setItemSelected(R.id.menuHeadline, true)

        setupFragment(FragmentHeadline())

        //open fragment
        bottomNavigation.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(id: Int) {
                when (id) {
                    R.id.menuHeadline -> setupFragment(FragmentHeadline())
                    R.id.menuSports -> setupFragment(FragmentSports())
                    R.id.menuTechnology -> setupFragment(FragmentTechnology())
                    R.id.menuBusiness -> setupFragment(FragmentBusiness())
                    R.id.menuHealth -> setupFragment(FragmentHealth())
                    R.id.menuEntertaiment -> setupFragment(FragmentEntertaiment())
                    R.id.menuSearch -> setupFragment(FragmentSearch())
                }
            }
        })
    }

    private fun setupFragment(fragment : Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentLayout, fragment)
        transaction.commit()
    }

}
