package com.aghogho.sharedpreferencesmvvm.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.aghogho.sharedpreferencesmvvm.Phonebook
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

const val DataStore_NAME = "PHONEBOOK"
val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = DataStore_NAME)
class ImplRepository(
    private val context: Context
): AbstractRepository {

    companion object {
        val NAME = stringPreferencesKey("NAME")
        val PHONE_NUMBER = stringPreferencesKey("PHONE")
        val ADDRESS = stringPreferencesKey("ADDRESS")
    }

    override suspend fun savePhoneBook(phonebook: Phonebook) {
        context.datastore.edit { phonebooks ->
            phonebooks[NAME] = phonebook.name
            phonebooks[PHONE_NUMBER] = phonebook.phone
            phonebooks[ADDRESS] = phonebook.address
        }
    }

    override suspend fun getPhoneBook() = context.datastore.data.map { phonebook ->
        Phonebook(
            name = phonebook[NAME]!!,
            address = phonebook[ADDRESS]?: "",
            phone = phonebook[PHONE_NUMBER]?: ""
        )
    }
}