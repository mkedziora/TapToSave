package com.example.taptosave.ui.chart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bi.chartapp.FoodSearch
import com.bi.chartapp.Parser
import com.example.taptosave.R
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.fragment_chart.*
import android.os.Bundle as Bundle1

class ChartFragment : Fragment() {

    private lateinit var root: View

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle1?
    ): View? {


        root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }
    fun onViewCreated(view: View?, container: ViewGroup?, savedInstanceState: Bundle1?) {
        val streamicecream = resources.openRawResource(R.raw.ice_cream)
        val iceData = Parser.toDataSet(streamicecream.reader())
        val streamyog = resources.openRawResource(R.raw.frozen_yoghurt)
        val yogData = Parser.toDataSet(streamyog.reader())

        val iceDataSet = getEntriesFromCSV(R.raw.ice_cream, "icecrea")
        val yogDataSet = getEntriesFromCSV(R.raw.frozen_yoghurt, "Frozen Yogurt")
        lineChart.data = LineData(
            iceDataSet,
            yogDataSet
        )
    }

    private fun getEntriesFromCSV(rawResId: Int, label: String): LineDataSet {

        var data: List<FoodSearch>? = null
        resources.openRawResource(rawResId).use { stream ->
            data = Parser.toDataSet(stream.reader())
        }
        val entries: MutableList<Entry> = ArrayList()

        data?.mapIndexed { index, foodSearch ->
            entries.add(
                Entry(index.toFloat(), foodSearch.value.toFloat(), foodSearch)
            )
        }

        return LineDataSet(entries, label)
    }
}