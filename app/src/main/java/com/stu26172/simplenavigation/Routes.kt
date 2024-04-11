package com.stu26172.simplenavigation

sealed class Routes(val route: String) {
   data object FirstScreen : Routes("first_screen")
   data object SecondScreen : Routes("second_screen")
   data object ThirdScreen : Routes("third_screen")
   data object SearchScreen : Routes("search_screen")
}