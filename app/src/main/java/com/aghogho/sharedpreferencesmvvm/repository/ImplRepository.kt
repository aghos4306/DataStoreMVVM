package com.aghogho.sharedpreferencesmvvm.repository

import android.content.Context

class ImplRepository(
    private val context: Context
): AbstractRepository {
    override suspend fun savePhoneBook() {
        TODO("Not yet implemented")
    }

    override suspend fun getPhoneBook() {
        TODO("Not yet implemented")
    }
}