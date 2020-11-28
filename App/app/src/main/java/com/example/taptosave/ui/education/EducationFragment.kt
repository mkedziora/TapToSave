package com.example.taptosave.ui.education

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taptosave.R
import kotlinx.android.synthetic.main.fragment_education.view.*

class SlideshowFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_education, container, false)

        val imageOne = root.imageView1
        val imageTwo = root.imageView2
        val imageThree = root.imageView3
        val imageFour = root.imageView4
        val linkOne = root.textViewLinkOne
        val linkTwo = root.textViewLinkTwo
        val linkThree = root.textViewLinkThree
        val linkFour = root.textViewLinkFour

        imageOne.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.worldwildlife.org/initiatives/freshwater"))
            startActivity(i)
        }
        linkOne.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.worldwildlife.org/initiatives/freshwater"))
            startActivity(i)
        }

        imageTwo   .setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.volusia.org/services/growth-and-resource-management/environmental-management/natural-resources/water-conservation/25-ways-to-save-water.stml"))
            startActivity(i)
        }
        linkTwo.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.volusia.org/services/growth-and-resource-management/environmental-management/natural-resources/water-conservation/25-ways-to-save-water.stml"))
            startActivity(i)
        }

        imageThree.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.h2ouse.net/why-save-water/"))
            startActivity(i)
        }
        linkThree.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.h2ouse.net/why-save-water/"))
            startActivity(i)
        }

        imageFour.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://ourworldindata.org/water-use-stress"))
            startActivity(i)
        }
        imageFour.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://ourworldindata.org/water-use-stress"))
            startActivity(i)
        }




        return root
    }
}