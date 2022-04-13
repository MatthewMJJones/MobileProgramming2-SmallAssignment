package za.ac.cput

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome to My Jetpack Compose Journey"
                )
                
                btnIcon()
                
                
            }
        }
    }
}

@Composable
fun btnIcon()
{
    var dialogState by remember {
        mutableStateOf(false)
    }
    
    Button(
        modifier = Modifier.padding(20.dp),
        shape = CircleShape,
        onClick = {
            dialogState = true
        }
    )
    {
        Text(text = "Info",
            fontSize = 25.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        Image(painter = painterResource(id = R.drawable.ic_baseline_ac_unit_24),
            contentDescription = null,
            modifier = Modifier
                .size(35.dp)
        )
    }
    
    JourneyAlertDialog(dialogState) {
        dialogState = !it
    }
}

@Composable
fun JourneyAlertDialog(
    dialogState: Boolean,
    onDismiss: (dialogState: Boolean) -> Unit
)
{
    if (dialogState)
    {
        AlertDialog(
            onDismissRequest = {
                onDismiss(dialogState)
            },
            title = {

            },
            text = {
              Text(
                  text = "Mobile devices are a part of our everyday lives, whether it's scrolling through Social Media or Ordering goods online. Learning Kotlin and Jetpack Compose has given me a deeper understanding of the structure of a mobile application. Mobile Programming is the future!",
                  fontSize = 12.sp
              )  
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDismiss(dialogState)
                    })
                {
                    Text("OK",
                        fontSize = 16.sp)
                }
            }
        )
    }
}

