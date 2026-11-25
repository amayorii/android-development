package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableIntStateOf
import com.example.lab1.ui.theme.Lab1Theme
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1Theme {
                Lab1App()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun Lab1App() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    var saveableStateHolder = rememberSaveableStateHolder();

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            painterResource(it.icon),
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            saveableStateHolder.SaveableStateProvider(currentDestination) {
                when(currentDestination){
                    AppDestinations.HOME -> HomeScreen(
                        Modifier.padding(innerPadding)
                    )
                    AppDestinations.FRIENDS -> FriendsScreen(
                        Modifier.padding(innerPadding)
                    )
                    AppDestinations.SETTINGS -> SettingsScreen(
                        Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: Int,
) {
    HOME("Home", R.drawable.ic_home),
    FRIENDS("Friends", R.drawable.ic_friends),
    SETTINGS("Settings", R.drawable.ic_settings),
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: MainViewModel = viewModel()) {
    var homeText by remember { mutableStateOf("this is home screen") }
    var subScreen by rememberSaveable { mutableIntStateOf(1) }
    val itemsList by viewModel.items.collectAsState()

    when(subScreen){
        1 -> {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = homeText,
                    color = Color(Color.Cyan.value)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        homeText = "yeah welcome"
                    },
                    modifier = Modifier.width(200.dp).height(50.dp)
                ) {
                    Text("Welcome")
                }
                Spacer(modifier = Modifier.height(16.dp));
                Button(
                    onClick = {
                        subScreen = 2;
                    },
                    modifier = Modifier.width(200.dp).height(50.dp)
                ) {
                    Text("Next screen")
                }
            }
        }

        2 -> {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "first subscreen", color = Color.Magenta)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { subScreen = 3 }) {
                    Text("Next screen")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { subScreen = 1 }) {
                    Text("Previous screen")
                }
            }
        }

        3 -> {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "second subscreen",
                    color = Color.Yellow
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { subScreen = 4 }) {
                    Text("Next screen")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { subScreen = 2 }) {
                    Text("Previous screen")
                }
            }
        }

        4 -> {
            Column(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    items(
                        items = itemsList,
                        key = { it.id }
                    ) { currentItem ->
                        when (currentItem) {
                            is CarItem -> CarItemView(currentItem)
                            is MotorcycleItem -> MotorcycleItemView(currentItem)
                            is PopularBrandsItem -> PopularBrandsHorizontalView(currentItem)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { subScreen = 3 }) {
                    Text("Previous screen")
                }
            }
        }
    }

}

@Composable
fun FriendsScreen(modifier: Modifier = Modifier) {
    var friendsText by remember { mutableStateOf("this is friends screen") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = friendsText,
            color = Color(Color.Green.value)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                friendsText = "friend has been added"
            },
            modifier = Modifier.width(200.dp).height(50.dp)
        ) {
            Text("Add friend")
        }
    }
}

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    var settingsText by remember { mutableStateOf("this is settings screen") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = settingsText,
            color = Color(Color.Red.value)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                settingsText = "settings saved"
            },
            modifier = Modifier.width(200.dp).height(50.dp)
        ) {
            Text("Save settings")
        }
    }
}