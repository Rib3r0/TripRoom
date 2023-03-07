package br.senai.sp.jandira.triproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TripRoomTheme {
                tripScreen();
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun tripScreen(){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.End) {
            Card(modifier = Modifier
                .width(150.dp)
                .height(50.dp),
                backgroundColor = Color(207, 6, 240),
                shape = RoundedCornerShape(0.dp,0.dp,0.dp,30.dp)

                ) {

            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {

            //Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    fontSize = 64.sp,
                    fontWeight = FontWeight(800),
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    lineHeight = 90.sp,
                    color = Color(207, 6, 240)

                )
                Text(
                    text = stringResource(id = R.string.message),
                    fontSize = 19.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = FontFamily(Font(R.font.poppins)),
                    lineHeight = 90.sp,
                    color = Color(160, 156, 156)

                )

            }
            //Main
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(red = 0, green = 255, blue = 0))
            ) {
                Text(text = "teste")
            }
            //Footer
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(red = 0, green = 0, blue = 255))
            ) {
                Text(text = "teste")
            }
            Card(modifier = Modifier
                .width(200.dp)
                .height(100.dp),
                backgroundColor = Color(red = 0, green = 255, blue = 0),

                ) {
                Text(text = "aaaa")
            }
        }
    }
}