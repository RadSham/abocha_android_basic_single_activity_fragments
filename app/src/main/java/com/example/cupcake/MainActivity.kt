/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cupcake

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Scaffold
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cupcake.model.OrderViewModel
import com.example.cupcake.ui.theme.CupcakeTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Activity for cupcake order flow.
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavHostController
    private val viewModel: OrderViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ViewGroupScreen()
            CupcakeTheme {
                navController = rememberNavController()
            }
            Scaffold() { paddingValues ->
                SetupNavGraph(navController, paddingValues, viewModel)
            }
        }
    }
}
