package com.aghogho.sharedpreferencesmvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.aghogho.sharedpreferencesmvvm.repository.ImplRepository
import javax.inject.Inject

class ActivityViewModel @Inject constructor(
    private val implRepository: ImplRepository
): ViewModel() {
}