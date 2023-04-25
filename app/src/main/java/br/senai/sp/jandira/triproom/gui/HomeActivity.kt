package br.senai.sp.jandira.triproom.gui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.model.Category
import br.senai.sp.jandira.triproom.model.Trip
import br.senai.sp.jandira.triproom.repository.CategoryRepository
import br.senai.sp.jandira.triproom.repository.TripRpository
import br.senai.sp.jandira.triproom.ui.theme.Shapes
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            TripRoomTheme {
                homePage(CategoryRepository.getCategories(), TripRpository.getTrips())
            }
        }
    }
}

@Composable
//name: String
fun homePage(categories: List<Category>, trips: List<Trip>) {

    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = RectangleShape
        ) {
            Image(
                painter = painterResource(id = R.drawable.paris) ,
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = stringResource(id = R.string.categories),
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            color = Color(56,54,54),
            fontSize = 14.sp
        )
        LazyRow() {
            items(categories) {
                Card(
                    modifier = Modifier
                        .size(width = 109.dp, height = 100.dp)
                        .padding(vertical = 10.dp, horizontal = 4.dp),
                    backgroundColor = Color.Magenta
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = it.categoryIcon ,
                            contentDescription = it.categoryName,
                            modifier = Modifier.size(40.dp)
                        )
                        Text(text = it.categoryName)
                    }

                }
            }

        }
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            placeholder = {
                Text(text = stringResource(id = R.string.search))

            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "")
            }}
        )
        Text(
            text = stringResource(id = R.string.past_trips),
            fontSize = 14.sp,
            color = Color(86,86,86),
            modifier = Modifier.padding(bottom = 10.dp)
        )
        LazyColumn(){
            items(trips){
                Card(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    backgroundColor = Color.Cyan
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.defaultimagethumbnail),
                            contentDescription = ""
                        )
                        Text( "${it.location}, ${it.starDate.year}")
                        Text( "${it.description}")
                        Text(
                            "${it.starDate} - ${it.endDate}",
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }

}
@Composable
@Preview(showSystemUi = true)
fun prewiel(){
        homePage(categories = CategoryRepository.getCategories(), TripRpository.getTrips())
}


