package com.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
//    private val id = "Chocopython"
//    private val password = "1111"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 1. 값을 가져온다.
        // 2. 클릭을 감지한다.
        // 3. 1번의 값을 다른 액티비티로 넘긴다.(화면 이동)
        btn_login.setOnClickListener {
            val inputEmail = TextInputEditText_email.text.toString()
            val inputPassword = TextInputEditText_password.text.toString()

            val nextIntent = Intent(this, LoginResultActivity::class.java)
            nextIntent.putExtra("email", inputEmail)
            nextIntent.putExtra("password", inputPassword)
            startActivity(nextIntent)
        }

//        btn_login.setOnClickListener {
//            val inputEmail = TextInputEditText_email.text?.trim().toString()
//            val inputPassword = TextInputEditText_password.text?.trim().toString()
//            if (inputEmail == id && inputPassword == password) {
//                val nextintent = Intent(this, LoginResultActivity::class.java)
//                nextintent.putExtra("email", inputEmail)
//                nextintent.putExtra("password", inputPassword)
//                startActivity(nextintent)
//            } else {
//                if (inputEmail.isEmpty() && inputPassword.isEmpty()) {
//                    Toast.makeText(this, " Email과 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
//                } else if (inputEmail != id) {
//                    Toast.makeText(this,"존재하지 않는 Email입니다.", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
    }
}
