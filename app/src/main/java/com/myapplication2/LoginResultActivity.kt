package com.myapplication2

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.myapplication2.Adapter.CalendarAdapter
import kotlinx.android.synthetic.main.activity_calendar.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet


class LoginResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

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

