package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val firstFragment = FirstFragment()
    val secondFragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        first_button.setOnClickListener{
            changeFragment(firstFragment)
        }

        second_button.setOnClickListener{
            changeFragment(secondFragment)
        }

        changeFragment(firstFragment)
    }

    fun changeFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_view, fragment)
            .commit();
    }
}