package com.myapplication2

import android.content.Intent
import android.graphics.Insets.add
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.OneShotPreDrawListener.add
import androidx.fragment.app.FragmentManager
import com.fxn.ariana.ArianaBackgroundListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.myapplication2.Adapter.NavigationViewPagerAdapter
import com.myapplication2.Fragment.*
import kotlinx.android.synthetic.main.activity_loginresult.*


class LoginResultActivity : AppCompatActivity() {

    private val fragmentManager: FragmentManager = supportFragmentManager
    private var fragmentAdd: AddFragment = AddFragment()
    private var fragmentMood: MoodFragment = MoodFragment()
    private var fragmentHabit: HabitFragment = HabitFragment()
    private var fragmentChart: ChartFragment = ChartFragment()
    private var fragmentProfile: ProfileFragment = ProfileFragment()

    //popup 호출시(푸시 리시버에서 호출)
//    var intentPopup: Intent = Intent(this, PopupActivity::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginresult)


        //로그인 알림
        Toast.makeText(this, "안녕!", Toast.LENGTH_SHORT).show()
        if (intent.hasExtra("email")) {
            email_get.text = intent.getStringExtra("email") + "님의 무드 패턴"

        } else {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
        }

        //fragment 전환
        chip_navigation.setOnItemSelectedListener { id ->
            when (id) {
                R.id.mood -> view_pg.currentItem = 0
                R.id.habit_tracker -> view_pg.currentItem = 1
                R.id.add -> view_pg.currentItem = 2
                R.id.chart -> view_pg.currentItem = 3
                R.id.profile -> view_pg.currentItem = 4

            }
        }

        view_pg.adapter = NavigationViewPagerAdapter(supportFragmentManager).apply {
            list = ArrayList<String>().apply {
                add("Mood")
                add("Habit")
                add("Add")
                add("Chart")
                add("Profile")
            }
        }

        view_pg.addOnPageChangeListener(
            ArianaBackgroundListener(
                getColors(),
                img_view,
                view_pg
            )
        )
        //호출시(푸시 리시버에서 호출)
//        intentPopup.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP
//        this.startActivity(intentPopup)
    }

    private fun getColors():IntArray{
        return intArrayOf(
            ContextCompat.getColor(this, R.color.navigation_color_moodtracker),
            ContextCompat.getColor(this, R.color.navigation_color_habittracker),
            ContextCompat.getColor(this, R.color.navigation_color_add),
            ContextCompat.getColor(this, R.color.navigation_color_chart),
            ContextCompat.getColor(this, R.color.navigation_color_profile)

        )
    }
}

