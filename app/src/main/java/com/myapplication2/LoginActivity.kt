package com.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
//    private val id = "Chocopython"
//    private val password = "1111"

//    class LoginData(val inputEmail: String?, val inputPassword: String?): Parcelable {
//
//        constructor(parcel: Parcel) : this(
//            parcel.readString(),
//            parcel.readString()
//        ) {
//        }
//
//        override fun writeToParcel(parcel: Parcel, flags: Int) {
//            parcel.writeString(inputEmail)
//            parcel.writeString(inputPassword)
//        }
//
//        override fun describeContents(): Int {
//            return 0
//        }
//
//        companion object CREATOR : Parcelable.Creator<LoginData> {
//            override fun createFromParcel(parcel: Parcel): LoginData {
//                return LoginData(parcel)
//            }
//
//            override fun newArray(size: Int): Array<LoginData?> {
//                return arrayOfNulls(size)
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
//1
        btn_login.setOnClickListener {
            val inputEmail = TextInputEditText_email.text.toString()
            val inputPassword = TextInputEditText_password.text.toString()

            val nextIntent = Intent(this, LoginResultActivity::class.java)
            nextIntent.putExtra("email", inputEmail)
            startActivity(nextIntent)
        }
//2
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

//        var loginData = LoginData(TextInputEditText_email.text.toString(), TextInputEditText_password.text.toString())
//
//        btn_login.setOnClickListener {
//            val nextIntent = Intent(this, LoginResultActivity::class.java)
//            nextIntent.putExtra("loginDataKey", loginData)
//            startActivity(nextIntent)
//        }

    }

}

