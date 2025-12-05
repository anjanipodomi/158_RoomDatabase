package com.example.myroomsatu.viewmodel

class EditViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetailSiswa.itemIdArg])
    init {
        viewModelScope.launch {
            uiStateSiswa = repositoriSiswa.getSiswaStream(idSiswa)
                .filterNotNull()
                .first()
                .toUiStateSiswa(true)
        }
    }

    fun updateUiState(detailsSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(detailsSiswa = detailsSiswa, isEntryValid = validasiInput(detailsSiswa))
    }

    private fun validasiInput(uiState: UIStateSiswa = uiStateSiswa): Boolean {
        return with(uiState.detailsSiswa) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    suspend fun updateSiswa() {
        if (validasiInput(uiStateSiswa.detailsSiswa)) {
            repositoriSiswa.updateSiswa(uiStateSiswa.detailsSiswa.toSiswa())
        }
    }


}