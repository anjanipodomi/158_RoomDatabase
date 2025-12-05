package com.example.myroomsatu.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myroomsatu.view.DetailSiswaScreen
import com.example.myroomsatu.view.EntrySiswaScreen
import com.example.myroomsatu.view.HomeScreen
import com.example.myroomsatu.view.route.DestinasiHome
import com.example.myroomsatu.view.route.DestinasiEntry
import com.example.myroomsatu.view.route.DestinasiDetailSiswa
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.myroomsatu.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.myroomsatu.view.route.DestinasiEditSiswa
import com.example.myroomsatu.view.EditSiswaScreen


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
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },

                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetailSiswa.route}/${it}")
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }

        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEditSiswa.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EditSiswaScreen(
                navigateBack = { navController.navigateUp() }
            )
        }


        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(itemIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { id ->
                    navController.navigate("${DestinasiEditSiswa.route}/$id")
                },
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}