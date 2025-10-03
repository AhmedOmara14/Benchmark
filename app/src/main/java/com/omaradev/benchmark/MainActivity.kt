package com.omaradev.benchmark

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Product(val name: String)

class MainActivity : ComponentActivity() {

    // Dummy JSON list
    private val jsonList = List(100) {
        """{"name":"Product #$it"}"""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                var showBad by remember { mutableStateOf(true) }

                Column(Modifier.fillMaxSize()) {
                    Row(Modifier
                        .fillMaxWidth()
                        .padding(8.dp)) {
                        Button(onClick = { showBad = true }, Modifier.weight(1f)) {
                            Text("Bad Example")
                        }
                        Spacer(Modifier.width(8.dp))
                        Button(onClick = { showBad = false }, Modifier.weight(1f)) {
                            Text("Good Example")
                        }
                    }

                    if (showBad) {
                        BadProductList(jsonList)
                    } else {
                        GoodProductList(jsonList)
                    }
                }
            }
        }
    }
}

@Composable
fun BadProductList(productsJson: List<String>) {
    val context = LocalContext.current
    LazyColumn {
        items(productsJson.size) { index ->
            val product = Json.decodeFromString<Product>(productsJson[index])

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                val bitmap = BitmapFactory.decodeResource(
                    context.resources,
                    R.drawable.img
                )
                //Image(bitmap.asImageBitmap(), contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text(product.name)
            }
        }
    }
}

@Composable
fun GoodProductList(productsJson: List<String>) {
    val products = remember {
        productsJson.map { Json.decodeFromString<Product>(it) }
    }

    LazyColumn {
        items(products.size) { index ->
            val product = products[index]
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = R.drawable.img,
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(product.name)
            }
        }
    }
}

