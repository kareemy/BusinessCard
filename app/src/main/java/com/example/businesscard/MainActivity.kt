package com.example.businesscard

import android.graphics.Paint
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFEADDFF)),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp()
{
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2E7D4))
    ) {
        Row (
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        )
        {
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                val image = painterResource(id = R.drawable.android_logo)
                Image(painter = image, contentDescription = null, modifier = Modifier
                    .height(120.dp)
                    .width(150.dp)
                    .background(Color.DarkGray)
                )
                Text(
                    stringResource(R.string.name),
                    fontSize = 30.sp
                )
                Text(
                    stringResource(R.string.title),
                    color = Color(0xFF096235),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Column (

            ) {
                ContactInformation(
                    icon = Icons.Filled.Phone,
                    description = stringResource(R.string.phone)
                )
                ContactInformation(
                    icon = Icons.Filled.Info,
                    description = stringResource(R.string.social)
                )
                ContactInformation(
                    icon = Icons.Filled.Email,
                    description = stringResource(R.string.email)
                )
            }
        }
    }
}

@Composable
fun BusinessCardAppVersion2()
{
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2E7D4))
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            val image = painterResource(id = R.drawable.android_logo)
            Image(painter = image, contentDescription = null, modifier = Modifier
                .height(120.dp)
                .width(150.dp)
                .background(Color.DarkGray)
            )

            Text(
                stringResource(id = R.string.name),
                fontSize = 30.sp
            )
            Text(
                stringResource(id = R.string.title),
                color = Color(0xFF096235),
                fontWeight = FontWeight.Bold
            )
        }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(bottom = 0.dp), // If I didn't center vertically, I could try padding
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column (

                    ) {
                ContactInformation(
                    icon = Icons.Filled.Phone,
                    description = stringResource(id = R.string.phone)
                )
                ContactInformation(
                    icon = Icons.Filled.Share,
                    description = stringResource(id = R.string.social)
                )
                ContactInformation(
                    icon = Icons.Filled.Email,
                    description = stringResource(id = R.string.email)
                )
            }
        }
       // Spacer (modifier = Modifier.fillMaxSize().weight(0.1f))
    }
}

@Composable
fun ContactInformation(icon: ImageVector, description: String, modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier
            .padding(4.dp),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = description,
            modifier = Modifier.padding(end = 8.dp),
            tint = Color(0xFF096235)
        )
        Text(description)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessOnePreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessTwoPreview() {
    BusinessCardTheme {
        BusinessCardAppVersion2()
    }
}