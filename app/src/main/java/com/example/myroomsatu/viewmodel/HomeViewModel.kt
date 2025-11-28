package com.example.myroomsatu.viewmodel

class HomeViewModel(private val repositoriSiswa: RepositoriSiswa) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}