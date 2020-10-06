package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val firstFragment = FirstFragment()
    val secondFragment = SecondFragment()
    val thirdFragment = ThirdFragment()
    val fourthFragment = FourthFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment(0)

        first_button.setOnClickListener{ setFragment(0) }
        second_button.setOnClickListener{ setFragment(1) }
        third_button.setOnClickListener{ setFragment(2) }
        fourth_button.setOnClickListener{ setFragment(3) }

    }

    fun setFragment(fragmentIndex : Int){
        val fragment = when(fragmentIndex){
            0 -> firstFragment
            1 -> secondFragment
            2 -> thirdFragment
            else -> fourthFragment
        }

        val statusBarColor = when(fragmentIndex){
            0 -> getColor(R.color.firstColor)
            1 -> getColor(R.color.secondColor)
            2 -> getColor(R.color.thirdColor)
            else -> getColor(R.color.fourthColor)
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_view, fragment)
            .commit();

        window.statusBarColor = statusBarColor
    }
}