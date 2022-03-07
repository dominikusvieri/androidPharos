package com.smartdev.ejurnal.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.smartdev.ejurnal.R
import com.smartdev.ejurnal.activity.MainActivity
import com.smartdev.ejurnal.data.TransferMethod

class ListRequestFragment : Fragment() {
    private lateinit var textView: TextView
    private lateinit var textView2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view =inflater.inflate(R.layout.fragment_list_request,container,false)
        textView = view.findViewById<View>(R.id.tvJudul) as TextView
        textView2 = view.findViewById<View>(R.id.tvDesc) as TextView

        val bundle = arguments
        val message = bundle!!.getString("mText")
        val message2 = bundle!!.getString("mText")

        textView.text = message
        textView2.text = message2

        return view
    }

}