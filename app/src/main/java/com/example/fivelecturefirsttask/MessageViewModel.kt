package com.example.fivelecturefirsttask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MessageViewModel : ViewModel() {

    private val message = MutableLiveData("")

    val getMessage: LiveData<String>
        get() = message

    fun setMessage(newMessage: String){
        message.value = newMessage
    }

}