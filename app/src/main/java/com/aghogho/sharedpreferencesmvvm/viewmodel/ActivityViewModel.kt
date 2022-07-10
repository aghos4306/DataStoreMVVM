package com.aghogho.sharedpreferencesmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aghogho.sharedpreferencesmvvm.Phonebook
import com.aghogho.sharedpreferencesmvvm.repository.ImplRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ActivityViewModel @Inject constructor(
    private val implRepository: ImplRepository
): ViewModel() {

    var phone: MutableLiveData<String> = MutableLiveData("")
    var address: MutableLiveData<String> = MutableLiveData("")
    var name: MutableLiveData<String> = MutableLiveData("")

    var phonebook: MutableLiveData<Phonebook> = MutableLiveData()

    fun saveData() {
        viewModelScope.launch(Dispatchers.IO) {
            implRepository.savePhoneBook(
                Phonebook(
                    name = name.value.toString(),
                    address = address.value!!,
                    phone = phone.value!!
                )
            )
        }
    }

    fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            implRepository.getPhoneBook().collect {
                phonebook.postValue(it)
            }
        }
    }

}