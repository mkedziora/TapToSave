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
import androidx.appcompat.app.AppCompatActivity

/*
class SettingsFragment : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_settings)

        val button = findViewById<Button>(R.id.buttonConfirm)
        val buttonConnect = findViewById<Button>(R.id.buttonConnect)
        val edit = findViewById<EditText>(R.id.editTextInhabitants)
        val editTarget = findViewById<EditText>(R.id.editTextTarget)

        button.setOnClickListener {
            Toast.makeText(this,"Powodzenia!", Toast.LENGTH_LONG).show();
            edit.text.clear()
            editTarget.text.clear()
        }
        buttonConnect.setOnClickListener {
            Toast.makeText(this, "Brak urządzeń w zasięgu", Toast.LENGTH_SHORT).show()
        }
    }
}
*/

class SettingsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_settings, container, false)

        val button = view?.findViewById<Button>(R.id.buttonConfirm)
        val buttonConnect = view?.findViewById<Button>(R.id.buttonConnect)
        val edit = view?.findViewById<EditText>(R.id.editTextInhabitants)
        val editTarget = view?.findViewById<EditText>(R.id.editTextTarget)
         button?.setOnClickListener {
            Toast.makeText(getActivity(),"Powodzenia!", Toast.LENGTH_LONG).show();
            edit!!.setText("")
            editTarget!!.setText("")
            }



        return root
    }
}
