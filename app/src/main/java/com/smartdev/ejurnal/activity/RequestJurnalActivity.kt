package com.smartdev.ejurnal.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.smartdev.ejurnal.R

class RequestJurnalActivity : AppCompatActivity() {
    private lateinit var etJudul: EditText
    private lateinit var etDesc: EditText
    private lateinit var btnRequest: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_jurnal)
        etJudul = findViewById(R.id.etJudulJurnal)
        etDesc = findViewById(R.id.etDeskripsiJurnal)
        btnRequest = findViewById(R.id.btnRequest)

        btnRequest.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("judul", etJudul.text.toString())
            bundle.putString("desc", etDesc.text.toString())

            val intent = Intent(this, JurnalMainActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}