package com.uiapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uiapp.ui.screens.addPersonScreen.AddPersonScreen
import com.uiapp.ui.screens.billBreakdownScreen.BillBreakdownScreen
import com.uiapp.ui.screens.billDetailsScreen.BillDetailsScreen
import com.uiapp.ui.screens.billSummaryScreen.BillSummaryScreen
import com.uiapp.ui.screens.cameraScreen.BillScannerScreen
import com.uiapp.ui.screens.editBillScreen.EditBillScreen
import com.uiapp.ui.screens.homeScreen.HomeScreen

object NavigationUtil {

    @Composable
    fun InitNavigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Route.HOME){
            composable(Route.HOME){ HomeScreen(navController) }
            composable(Route.BILLS_DETAILS){ BillDetailsScreen(navController) }
            composable(Route.CAMERA){ BillScannerScreen(navController) }
            composable(Route.BILL_SUMMARY) { BillSummaryScreen(navController) }
            composable(Route.EDIT_BILL) { EditBillScreen(navController) }
            composable(Route.ADD_PERSON) { AddPersonScreen(navController) }
            composable(Route.SUMMARY_BREAKDOWN) { BillBreakdownScreen(navController) }
        }

    }


}