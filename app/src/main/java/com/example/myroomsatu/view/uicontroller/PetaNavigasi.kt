package com.example.myroomsatu.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myroomsatu.view.EntrySiswaScreen
import com.example.myroomsatu.view.HomeScreen
import com.example.myroomsatu.view.route.DestinasiHome
import com.example.myroomsatu.view.route.DestinasiEntry

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier) {
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = DestinasiHome.route,
        modifier = Modifier) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {navController.navigate(DestinasiEntry.route)},

                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetailSiswa.route}/${it}")}
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = {navController.popBackStack()})
        }

        composable(route = DestinasiDetailSiswa.routeWithArgs,
            arguments= listOf(navArgument(itemIdArg) {
                type= navType.intType
            })
        ){
            DetailSiswaScreen(
                //navigasiToEditItem = {navController.navigate("${DestinasiEditSiswa.route}/$it")},
                {navController.navigateUp() })
        }

    }
}