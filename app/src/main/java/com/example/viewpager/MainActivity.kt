package com.example.viewpager

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.example.viewpager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    var fragments = listOf(FragmentOne(), FragmentTwo(), FragmentThree())
    var tabtext = listOf("Home", "Notifications", "Favourites")
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initviewPager()
        inittabLayout()

    }

    private fun inittabLayout() {
        TabLayoutMediator(binding.tab, binding.viewpage) { tab, position ->
            tab.text = tabtext[position]
        }.attach()
    }

    private fun initviewPager() {
        binding.viewpage.adapter = FragmentViewPagerAdapter(this, fragments)
    }




}