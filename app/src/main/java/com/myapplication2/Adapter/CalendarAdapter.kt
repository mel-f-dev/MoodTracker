package com.myapplication2.Adapter

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.TextView
import com.myapplication2.R
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class CalendarAdapter(context: Context, days: ArrayList<Date>, eventDays: HashSet<Date>, inputMonth: Int):
        ArrayAdapter<Date>(context, R.layout.activity_calendar, days) {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val inputMonth = inputMonth - 1

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view = view
        val calendar = Calendar.getInstance()
        val date = getItem(position)

        calendar.time = date
        val day = calendar.get(Calendar.DATE)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        //오늘에 해당하는 캘린더 가져오기
        val today = Date()
        val calendarToday = Calendar.getInstance()
        calendarToday.time = today

        //날짜 디자인으로 먼저 만들어둔 calendar_day_layout을 inflate
        if (view == null) {
            view = inflater.inflate(R.layout.calendar_day_layout, parent, false)
        }

        //View의 생김새와 일자의 디자인 커스텀
        (view as TextView).setTypeface(null, Typeface.NORMAL)
        view.setTextColor(Color.parseColor("#8BD9DF"))

        //inputMonth: ViewPager의 해당 페이지에 출력하는 Month를 표시
        if (month != inputMonth || year != calendarToday.get(Calendar.YEAR)) {
            view.visibility = View.INVISIBLE
        }
        if (month == calendarToday.get(Calendar.MONTH) && year == calendarToday.get(Calendar.YEAR) && day == calendarToday.get(Calendar.DATE)) {
            // 오늘의 날짜에 하고싶은 event를 정의
        }
        // 날짜를 텍스트뷰에 설정정
       view.text = calendar.get(Calendar.DATE).toString()

        return view
    }
}