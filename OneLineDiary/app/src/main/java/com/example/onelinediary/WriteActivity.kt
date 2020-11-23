package com.example.onelinediary

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_write.*
import java.util.*

class WriteActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_write)

        button_write_save.setOnClickListener {
            intent.putExtra("datetime", Date())
            intent.putExtra("data", edittext_write.text.toString())
            setResult(RESULT_OK)
            finish()
        }
    }
}