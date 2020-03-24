package com.myapplication2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.myapplication2.Adapter.IntroViewPagerAdapter
import com.myapplication2.custom_class.ScreenItem
import kotlinx.android.synthetic.main.activity_intro.*
import java.util.ArrayList

class IntroActivity : AppCompatActivity() {
    private var screenPager: ViewPager? = null,
    var introViewPagerAdapter: IntroViewPagerAdapter? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_intro)


            //fill list screen
            var mList: MutableList<ScreenItem> = ArrayList()
            mList.add(ScreenItem("Mood Tracking", "", R.drawable.img1))
            mList.add(ScreenItem("오늘의 색깔", "", R.drawable.img2))
            mList.add(ScreenItem("하루를 정리", "", R.drawable.img3))

            //setup viewpager
            screenPager = findViewById(R.id.screen_viewpager)
            introViewPagerAdapter = IntroViewPagerAdapter(this, mList)
            screenPage.setAdapter(introViewPagerAdapter)

    }
}
