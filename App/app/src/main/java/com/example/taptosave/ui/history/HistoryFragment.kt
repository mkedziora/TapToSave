package com.example.taptosave.ui.history

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bi.chartapp.Parser
import com.example.taptosave.R
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_history.view.*

class HistoryFragment: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val streamBananas = resources.openRawResource(R.raw.january)
//        val bananaData = Parser.toDataSet(streamBananas.reader())
        val bananaDataSet = getEntriesFromCSV(R.raw.january, "January")
        val root = inflater.inflate(R.layout.fragment_history, container, false)
        root.barChart.description.text = "Daily Water usage during the month"
        root.barChart.xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        root.barChart.getAxisRight().setDrawGridLines(false);
        root.barChart.getAxisLeft().setDrawGridLines(false);
        root.barChart.getXAxis().setDrawGridLines(false);
        val limitLine = LimitLine(140.toFloat())
        limitLine.setLineColor(Color.RED);
        limitLine.setLineWidth(2f);
//        limitLine.setLabel("Desired Level");
        root.barChart.axisLeft.addLimitLine(limitLine)

        val rightYAxis = root.barChart.axisRight
        rightYAxis.isEnabled = false
        root.barChart.data = BarData(
            bananaDataSet
        )


        return root

    }




    private fun getEntriesFromCSV(rawResId: Int, label: String): BarDataSet {

        var data: List<FoodSearch>? = null
        resources.openRawResource(rawResId).use { stream ->
            data = Parser.toDataSet(stream.reader())
        }
        val barEntry: MutableList<BarEntry> = ArrayList()

        data?.mapIndexed { index, foodSearch ->
            barEntry.add(
                BarEntry(index.toFloat(), foodSearch.value.toFloat(), foodSearch)
            )
        }

        return BarDataSet(barEntry, label)
    }


}
