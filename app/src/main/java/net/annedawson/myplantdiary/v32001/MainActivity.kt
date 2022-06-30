// Last updated: Thursday 30th June 2022, 14:54 PT

package net.annedawson.myplantdiary.v32001

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.tooling.data.EmptyGroup.location
import androidx.compose.ui.tooling.preview.Preview
import net.annedawson.myplantdiary.v32001.ui.theme.MyPlantDiaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPlantDiaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SpecimenFacts()
                }
            }
        }
    }
}

@Composable
fun SpecimenFacts() {
    var plantName by remember { mutableStateOf("")}
    var location by remember { mutableStateOf("")}
    var description by remember { mutableStateOf("")}
    var datePlanted by remember { mutableStateOf("")}
    val context = LocalContext.current
    // a context is an interface to global info about an app,
    // and allows access to app-specific resources
    // https://developer.android.com/reference/android/content/Context.html

    Column {
        OutlinedTextField(
            value = plantName,
            onValueChange = {plantName = it},
            label = { Text(stringResource(R.string.plantName))},
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = location,
            onValueChange = {location = it},
            label = { Text(stringResource(R.string.location))},
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = description,
            onValueChange = {description = it},
            label = { Text(stringResource(R.string.description))},
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = datePlanted,
            onValueChange = {datePlanted = it},
            label = { Text(stringResource(R.string.datePlanted))},
            modifier = Modifier.fillMaxWidth()
        )
        Button (
            onClick = {
                Toast.makeText(context, "$plantName $location $description $datePlanted", Toast.LENGTH_LONG).show()
            }
        ){
            Text(text = "Save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyPlantDiaryTheme {
        SpecimenFacts()
    }
}