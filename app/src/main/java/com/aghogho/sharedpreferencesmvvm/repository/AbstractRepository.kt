package com.aghogho.sharedpreferencesmvvm.repository

import com.aghogho.sharedpreferencesmvvm.Phonebook
import kotlinx.coroutines.flow.Flow

interface AbstractRepository {

    suspend fun savePhoneBook(phonebook: Phonebook)

    suspend fun getPhoneBook(): Flow<Phonebook>

}