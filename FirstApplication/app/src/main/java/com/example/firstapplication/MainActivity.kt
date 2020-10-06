package com.example.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 버튼에 onClickListener 추가하여 버튼 클릭 시 함수 실행
        submit_button.setOnClickListener{
            if (edit_text.text.isBlank()) Toast.makeText(this, "값이 없어요!", Toast.LENGTH_LONG).show()
            else clickFunction()
        }

        edit_text.requestFocus() // 에딧텍스트에 포커스를 준다 (Manifest 안에 softInput이 설정되어 있으면 키보드도 나타남)
        /*
        매니페스트에서 추가되어야 하는 내용
        <activity android:name=".MainActivity"
            android:windowSoftInputMode="stateVisible">
         */
    }
    fun clickFunction(){
        //println("SOMETHING")
        Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_LONG).show()

        val timeString = SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.getDefault()).format(Date())
        time_text.text = timeString
        input_text.text = edit_text.text.toString() // 입력값

        edit_text.text.clear()

        // hide keyboard
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(edit_text.windowToken, 0)

        // 새로운 입력값으로 바꾸고 싶다면......
        // edit_text.setText("새로운 입력값") // 내용 변경
        // edit_text.setSelection(edit_text.text.length) // 맨 끝으로 커서 이동
    }
}