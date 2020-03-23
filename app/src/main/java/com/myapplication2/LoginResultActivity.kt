package com.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_loginresult.*


class LoginResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginresult)

        if (intent.hasExtra("email")) {
            TextView_get.text = intent.getStringExtra("email")

        } else {
            Toast.makeText(this, "전달된 이름이 없습니다.", Toast.LENGTH_SHORT).show()
        }

    }
}
