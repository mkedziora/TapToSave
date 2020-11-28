package com.example.taptosave.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taptosave.MainActivity
import com.example.taptosave.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import com.example.taptosave.ui.details.DetailsFragment
import kotlinx.android.synthetic.main.details_fragment.*
import kotlinx.android.synthetic.main.details_fragment.view.*

class HomeFragment : Fragment() {

    private lateinit var root: View

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)
        root.button.setOnClickListener {
            (context as MainActivity).changeFragment(DetailsFragment.newInstance())
                }
        val todayScore = root.textView2.text
        val score = root.textView3.text
        val tipOfTheDay = root.textView4.text
        root.textView4.text = """$tipOfTheDay
            
To save more water, don't use it too much"""
        return root
    }
}