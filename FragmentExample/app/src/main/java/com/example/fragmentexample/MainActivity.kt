package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val firstFragment = FirstFragment()
    val secondFragment = SecondFragment()
    val thirdFragment = ThirdFragment()
    val fourthFragment = FourthFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragment(firstFragment)
        window.statusBarColor = getColor(R.color.firstColor)

        first_button.setOnClickListener{
            changeFragment(firstFragment)
            window.statusBarColor = getColor(R.color.firstColor)
        }

        second_button.setOnClickListener{
            changeFragment(secondFragment)
            window.statusBarColor = getColor(R.color.secondColor)
        }

        third_button.setOnClickListener{
            changeFragment(thirdFragment)
            window.statusBarColor = getColor(R.color.thirdColor)
        }

        fourth_button.setOnClickListener{
            changeFragment(fourthFragment)
            window.statusBarColor = getColor(R.color.fourthColor)
        }

    }

    fun changeFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_view, fragment)
            .commit();
    }
}