package com.example.fivelecturefirsttask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class ReceiverFragment : Fragment() {

    companion object {

        private const val MESSAGE = "MESSAGE"

        fun newInstance(message: String): Fragment =
            ReceiverFragment().apply {
                var bundle = Bundle()
                bundle.putString(MESSAGE, message)
                arguments = bundle
            }
    }

    lateinit var message: TextView

    lateinit var viewModel: MessageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MessageViewModel::class.java]


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receivedMessage = arguments?.getString(MESSAGE)
        if (receivedMessage != null) {
            viewModel.setMessage(receivedMessage)
        }

        viewModel.getMessage.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.message).text = it.toString()
        }
        view.findViewById<Button>(R.id.read).setOnClickListener {
            viewModel.setMessage("All messages is read")
        }


    }


}