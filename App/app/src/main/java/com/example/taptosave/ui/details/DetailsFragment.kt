package com.example.taptosave.ui.details

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.taptosave.R
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
        val roomsArray = arrayOf("kitchen", "bathroom")
        
        return root
    }



    override fun onResume() {
        super.onResume()
        root.details.visibility = View.VISIBLE
    }
}