package com.myapplication2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_loginresult.*


class LoginResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginresult)

        if (intent.hasExtra("email")) {
            email_get.text = intent.getStringExtra("email") + "님의 무드 패턴"

        } else {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
        }
//        if (intent.hasExtra("loginDataKey")) {
//            val login = intent.getParcelableExtra<LoginActivity.LoginData>("loginDataKey")
//            TextView_get.text = "${login.inputEmail}님의 비밀번호는 ${login.inputPassword}입니다."
//        } else {
//            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
//        }

    }

}

