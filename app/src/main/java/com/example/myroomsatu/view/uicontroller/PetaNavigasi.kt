package com.example.myroomsatu.view.uicontroller

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
) {}