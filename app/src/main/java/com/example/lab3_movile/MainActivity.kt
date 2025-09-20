package com.example.lab3_movile


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab3_movile.ui.theme.Lab3_movileTheme // <- CAMBIA ESTO por tu tema

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab3_movileTheme { // <- Y ESTO
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    // Definimos los colores para que sea más fácil de modificar
    val backgroundColor = Color(0xFFD2E8D4)
    val brandColor = Color(0xFF006D3B)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceAround, // Empuja el contenido hacia el centro y los bordes
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Sección superior: Logo, Nombre y Título
            BusinessCardHeader(brandColor = brandColor)
            // Sección inferior: Información de contacto
            ContactInfo(brandColor = brandColor)
        }
    }
}

@Composable
fun BusinessCardHeader(brandColor: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp) // Espacio entre elementos
    ) {
        // Logo
        Box(
            modifier = Modifier
                .background(Color(0xFF073042))
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo), // Asegúrate de tener esta imagen
                contentDescription = "Android Logo",
                modifier = Modifier.size(80.dp)
            )
        }
        // Nombre
        Text(
            text = "Luis Miguel Toledo",
            fontSize = 40.sp,
            fontWeight = FontWeight.Light,
            color = Color.Black
        )
        // Título
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = brandColor
        )
    }
}

@Composable
fun ContactInfo(brandColor: Color) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espacio entre cada línea de contacto
    ) {
        ContactRow(
            icon = Icons.Rounded.Phone,
            text = "+11 (123) 444 555 666",
            iconColor = brandColor
        )
        ContactRow(
            icon = Icons.Rounded.Share,
            text = "@AndroidDev",
            iconColor = brandColor
        )
        ContactRow(
            icon = Icons.Rounded.Email,
            text = "luis.toledo.l@android.com",
            iconColor = brandColor
        )
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String, iconColor: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null, // Descriptivo para accesibilidad
            tint = iconColor,
            modifier = Modifier.padding(end = 24.dp)
        )
        Text(text = text, color = Color.Black)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    Lab3_movileTheme { // <- Y ESTO
        BusinessCardApp()
    }
}