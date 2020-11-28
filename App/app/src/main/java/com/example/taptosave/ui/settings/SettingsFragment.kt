package com.example.taptosave.ui.settings

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taptosave.R
import android.widget.Button
import android.widget.Toast
import android.widget.EditText
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
        val edit = root.editTextInhabitants
        val editTarget = root.editTextTarget
         button.setOnClickListener {
             Toast.makeText(getActivity(), "Powodzenia!", Toast.LENGTH_LONG).show();
             edit.text.clear()
             editTarget.text.clear()
         }
         buttonConnect.setOnClickListener {
             Toast.makeText(getActivity(), "Brak urządzeń w zasięgu", Toast.LENGTH_LONG).show();
         }




        return root
    }
}
