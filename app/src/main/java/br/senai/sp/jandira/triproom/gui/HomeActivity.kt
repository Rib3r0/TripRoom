package br.senai.sp.jandira.triproom.gui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                homePage()
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun homePage() {

    val context = LocalContext.current

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item(){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    ,
                backgroundColor = Color.DarkGray,
                shape = RoundedCornerShape(0.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.paris),
                    contentDescription = "",
                )
                Column(horizontalAlignment = Alignment.End) {

                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(13.dp),
                        shape = RoundedCornerShape(100.dp),
                        border = BorderStroke(2.dp, Color.White)
                    ) {


                        Image(painter = painterResource(id = R.drawable.defaultimagethumbnail), contentDescription = "")
                    }
                    Text(
                        modifier = Modifier.padding(15.dp,0.dp),
                        text = "Eduardo Ribeiro",
                        color = Color.White
                    )

                }

            }
        }

    }
}

