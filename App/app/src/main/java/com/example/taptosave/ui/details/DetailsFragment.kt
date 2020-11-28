package com.example.taptosave.ui.details

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bi.chartapp.Parser
import com.example.taptosave.MainActivity
import com.example.taptosave.R
import com.example.taptosave.ui.history.FoodSearch
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.details_fragment.*
import kotlinx.android.synthetic.main.details_fragment.view.*

class DetailsFragment : Fragment() {

    companion object {
        fun newInstance(): DetailsFragment {
            return DetailsFragment()
        }
    }

    private lateinit var root: View

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.details_fragment, container, false)

        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        fragmentManager.registerFragmentLifecycleCallbacks(object :
            FragmentManager.FragmentLifecycleCallbacks() {
            override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
                super.onFragmentPaused(fm, f)
                root.details.visibility = View.INVISIBLE
            }
        }, true)
        val bananaDataSet = getEntriesFromCSV(R.raw.bathroom1, "bathroom1")
        root.roomslist.setSelection(9);//position 1
        root.roomslist.setItemChecked(9, true);//position 1




        root.barChart2.description.text = "Today's usage per hour"
        root.barChart2.xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        root.barChart2.getAxisRight().setDrawGridLines(false);
        root.barChart2.getAxisLeft().setDrawGridLines(false);
        root.barChart2.getXAxis().setDrawGridLines(false);
        val limitLine = LimitLine(140.toFloat())
        limitLine.setLineColor(Color.RED);
        limitLine.setLineWidth(2f);

//        limitLine.setLabel("Desired Level");
        root.barChart2.axisLeft.addLimitLine(limitLine)

        val rightYAxis = root.barChart2.axisRight
        rightYAxis.isEnabled = false
        root.barChart2.data = BarData(
            bananaDataSet
        )
        root.roomslist.setOnItemClickListener{ parent, view, position, id ->
            val dataArray = resources.getStringArray(R.array.roomsList)

            val monthsPath = listOf(R.raw.kitchen, R.raw.bathroom1, R.raw.bathroom2)

            val bananaDataSet = getEntriesFromCSV(monthsPath[position], dataArray[position].toString())
            root.barChart2.data = BarData(
                bananaDataSet
            )
            root.barChart2.invalidate()

        }
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



    override fun onResume() {
        super.onResume()
        root.details.visibility = View.VISIBLE
    }
}