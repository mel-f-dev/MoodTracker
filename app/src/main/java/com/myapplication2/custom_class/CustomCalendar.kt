package com.myapplication2.custom_class

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.GridView
import android.widget.LinearLayout
import com.myapplication2.R
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class CalendarView: LinearLayout {
    lateinit var header: LinearLayout
    lateinit var gridView: GridView

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        initControl(context, attrs!!)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttrs: Int) : super(context, attrs, defStyleAttrs)

    private fun assignUiElements() {
        header = findViewById(R.id.calendar_header)
        gridView = findViewById(R.id.calendar_grid)
    }

    fun updateCalender(events: HashSet<Date>, inputCalendar: Calendar) {
        val cells = ArrayList<Date>()
        inputCalendar.set(Calendar.DAY_OF_MONTH, 1)

        val monthBeginningCell = inputCalendar.get(Calendar.DAY_OF_WEEK) - 1
        inputCalendar.add(Calendar.DAY_OF_MONTH, -monthBeginningCell)

        //그리드에 집어넣을 cell들의 setup
        while (cells.size < (Calendar.DAY_OF_MONTH) + inputCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            cells.add(inputCalendar.time)
            inputCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        //그리드 업데이트
        gridView.adapter = CalendarAdapter(
            context,
            cells,
            events,
            inputCalendar.get(Calendar.MONTH)
        )
    }

    private fun initControl(context: Context, attrs: AttributeSet) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.activity_calendar, this)
        assignUiElements()
    }
}