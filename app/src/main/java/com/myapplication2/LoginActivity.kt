package com.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )


        setContentView(R.layout.activity_login)



        btn_login.setOnClickListener {
            val inputEmail = TextInputEditText_email.text.toString()
            val inputPassword = TextInputEditText_password.text.toString()

            if (inputEmail.isEmpty() && inputPassword.isEmpty()) {
                Toast.makeText(this, "Email과 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                val nextIntent = Intent(this, LoginResultActivity::class.java)
                nextIntent.putExtra("email", inputEmail)
                startActivity(nextIntent)
            }
        }
    }
}

