package com.myapplication2

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_intro.*
import java.util.ArrayList

class IntroActivity : AppCompatActivity() {
    private var screenPager: ViewPager? = null
    var introViewPagerAdapter: IntroViewPagerAdapter? = null
    var tabIndicator: TabLayout? = null
    var btnNext: Button? = null

    var position: Int = 0

    public override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            //make the activity on full screen
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )

            setContentView(R.layout.activity_intro)

            //hide the action bar
            supportActionBar!!.hide()

            //ini views
            btnNext = findViewById(R.id.btn_next)
            tabIndicator = findViewById(R.id.tab_indicator)

            //fill list screen
            var mList: MutableList<ScreenItem> = ArrayList()
            mList.add(
                ScreenItem(
                    "내 감정의 색깔",
                    """매 시간 변화하는 내 감정의 컬러
                        |당신의 기분은 무슨 색깔인가요?
                        |직관적으로 원하는 색깔을 선택해보세요.""".trimMargin(),
                    R.drawable.img4
                )
            )
            mList.add(
                ScreenItem(
                    "하루의 컬러를 모아",
                    """하루의 컬러를 모으면 어떤 모습일까?
                        |오늘 당신의 감정이 하나의 작품이 됩니다.""".trimMargin(),
                    R.drawable.img2
                )
            )
            mList.add(
                ScreenItem(
                    "컬러 테라피",
                    """감정의 색깔을 모아 모아
                        |혼자서도 할 수 있는 컬러테라피
                        |감정을 스스로 조절할 수 있도록 이미지 트레이닝을 시작해보세요.""".trimMargin(),
                    R.drawable.img3
                )
            )

            //setup viewpager
            screenPager = findViewById(R.id.screen_viewpager)
            introViewPagerAdapter =
                IntroViewPagerAdapter(this, mList)
            screenPager?.setAdapter(introViewPagerAdapter)

            //setup tablayout with viewpager
            tabIndicator?.setupWithViewPager(screenPager)

            //next button click Listener
            btnNext?.setOnClickListener (View.OnClickListener {
                position = screenPager!!.getCurrentItem()
                if (position < mList.size) {
                    position ++
                    screenPager!!.setCurrentItem(position)
                }
            })


    }
}
