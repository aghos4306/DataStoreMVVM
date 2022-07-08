package com.aghogho.sharedpreferencesmvvm.repository

interface AbstractRepository {

    suspend fun savePhoneBook()

    suspend fun getPhoneBook()

}