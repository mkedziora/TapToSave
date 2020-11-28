package com.example.taptosave.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.taptosave.R
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_settings.view.*

class SettingsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_settings, container, false)

        val button = root.buttonConfirm
        val buttonConnect = root.buttonConnect
         button.setOnClickListener {
             Toast.makeText(getActivity(), "Powodzenia!", Toast.LENGTH_LONG).show();
         }
         buttonConnect.setOnClickListener {
             Toast.makeText(getActivity(), "Brak urządzeń w zasięgu", Toast.LENGTH_LONG).show();
         }




        return root
    }
}
