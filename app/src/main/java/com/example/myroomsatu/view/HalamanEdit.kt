package com.example.myroomsatu.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myroomsatu.R
import com.example.myroomsatu.viewmodel.EditViewModel
import com.example.myroomsatu.viewmodel.provider.PenyediaViewModel
import kotlinx.coroutines.launch
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditSiswaScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val uiState = viewModel.uiStateSiswa
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            SiswaTopAppBar(
                title = stringResource(R.string.edit_siswa),
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) { innerPadding ->

        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // FORM INPUT EDIT
            OutlinedTextField(
                value = uiState.detailSiswa.nama,
                onValueChange = { viewModel.updateUiState(uiState.detailSiswa.copy(nama = it)) },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = uiState.detailSiswa.alamat,
                onValueChange = { viewModel.updateUiState(uiState.detailSiswa.copy(alamat = it)) },
                label = { Text("Alamat") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = uiState.detailSiswa.telpon,
                onValueChange = { viewModel.updateUiState(uiState.detailSiswa.copy(telpon = it)) },
                label = { Text("Telpon") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    coroutineScope.launch {
                        viewModel.updateSiswa()
                        navigateBack()
                    }
                },
                enabled = uiState.isEntryValid,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Update")
            }
        }
    }
}
