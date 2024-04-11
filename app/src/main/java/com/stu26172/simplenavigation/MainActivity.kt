package com.stu26172.simplenavigation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.stu26172.simplenavigation.components.SearchBar
import com.stu26172.simplenavigation.ui.theme.MoviesAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            val currentDestination = navBackStackEntry?.destination
            val searchQuery = remember { mutableStateOf(TextFieldValue()) }
            val context = LocalContext.current

            MoviesAppTheme(dynamicColor = false) {
                Scaffold(
                    topBar = {
                        AnimatedContent(
                            targetState = currentDestination?.route == Routes.SearchScreen.route,
                            label = ""
                        ) {
                            if (it) {

                                SearchBar(query = searchQuery.value, onQueryChange = { textField ->
                                    searchQuery.value = textField
                                }, onBackClick = {
                                    navController.popBackStack()
                                }, onClearClick = {
                                    searchQuery.value = TextFieldValue()
                                })
                            } else {
                                CenterAlignedTopAppBar(title = {}, actions = {
                                    IconButton(onClick = { navController.navigate(Routes.SearchScreen.route) }) {
                                        Icon(
                                            imageVector = Icons.Rounded.Search,
                                            contentDescription = null
                                        )
                                    }
                                    IconButton(onClick = {
                                        Toast.makeText(
                                            context, "Navigate to Settings", Toast.LENGTH_SHORT
                                        ).show()
                                    }) {
                                        Icon(
                                            imageVector = Icons.Rounded.Settings,
                                            contentDescription = null
                                        )
                                    }
                                })

                            }
                        }
                    }) { paddingValues ->
                    AppNavigation(
                        searchQuery = searchQuery.value.text,
                        paddingValues = paddingValues,
                        navController = navController
                    )
                }
            }
        }
    }
}

