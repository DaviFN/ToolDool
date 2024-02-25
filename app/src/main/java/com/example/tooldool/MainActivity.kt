package com.example.tooldool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

@Composable
fun TodoItem(itemName: String) {
    val checkedState = remember { mutableStateOf(false) }
    Row(verticalAlignment = CenterVertically) {
        Text(itemName)
        Checkbox(checked = checkedState.value,
            onCheckedChange = { checkedState.value = it })
    }
}

@Composable
fun ScrollableList(items: List<String>) {
    LazyColumn {
        //items(items) { item ->
        //    // Add your UI components here for each item in the list
        //}
        //Add a single item
        items(items) {item ->
            TodoItem(item)
        }
    }
}

class MainActivity : AppCompatActivity() {
    private lateinit var doneCheckbox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //doneCheckbox = findViewById<CheckBox>(R.id.checkBox)

        setContent {

            var labels : List<String> = emptyList()
            for (i in 1..100) {
                labels = labels.plus("Item " + i.toString())
            }

            ScrollableList(labels)
        }

    }
}