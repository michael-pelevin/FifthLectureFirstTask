package com.example.fivelecturefirsttask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class SenderFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.send).setOnClickListener {
            replaceFragment()
        }
    }

    private fun replaceFragment() {
        val receiverFragment = ReceiverFragment.newInstance("Message from sender")
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, receiverFragment).addToBackStack(null).commit()
    }

    companion object {
        fun newInstance() = SenderFragment()
    }
}