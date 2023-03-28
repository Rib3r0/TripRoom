package br.senai.sp.jandira.triproom.gui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.components.BottomShape
import br.senai.sp.jandira.triproom.components.TopShape

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            signUpScreen()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun signUpScreen() {

    var scrollState = rememberScrollState(0)

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TopShape()
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.signup),
                fontSize = 42.sp,
                fontWeight = FontWeight(800),
                fontFamily = FontFamily(Font(R.font.poppins)),
                lineHeight = 90.sp,
                color = Color(207, 6, 240)
            )
            Text(
                text = stringResource(id = R.string.create),
                fontSize = 19.sp,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily(Font(R.font.poppins)),
                lineHeight = 90.sp,
                color = Color(160, 156, 156)
            )
            Box(contentAlignment = Alignment.BottomEnd){
                Card(
                    modifier = Modifier.size(100.dp),
                    shape = CircleShape
                ){
                    Icon(
                        painter = painterResource(
                            id = R.drawable.person_24),
                        contentDescription = "",
                        tint = Color(207, 6, 240)
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.camera_alt_24),
                    contentDescription = "",
                    tint = Color(207, 6, 240)
                )

            }
        }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .height(310.dp)){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center
        ) {
            var username by remember{ mutableStateOf(TextFieldValue("")) }

            OutlinedTextField(
                value = username,
                onValueChange = {newUsername -> username = newUsername},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = stringResource(id = R.string.username))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.person_24),
                        contentDescription = stringResource(id = R.string.email_description),
                        tint = Color(207,1,240)
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color(207, 6, 240),
                    focusedBorderColor = Color(207, 6, 240)
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            var phone by remember{ mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = phone,
                onValueChange = {newPhone -> phone = newPhone},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = stringResource(id = R.string.phone))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.phone_24),
                        contentDescription = stringResource(id = R.string.email_description),
                        tint = Color(207,1,240)
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color(207, 6, 240),
                    focusedBorderColor = Color(207, 6, 240)
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            var email by remember{ mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = email,
                onValueChange = {newEmail -> email = newEmail},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = stringResource(id = R.string.email))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.email_24),
                        contentDescription = stringResource(id = R.string.email_description),
                        tint = Color(207,1,240)
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color(207, 6, 240),
                    focusedBorderColor = Color(207, 6, 240)
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            var password by remember{ mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = password,
                onValueChange = {newPassword -> password = newPassword},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = stringResource(id = R.string.password))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.lock_24),
                        contentDescription = stringResource(id = R.string.email_description),
                        tint = Color(207,1,240)
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color(207, 6, 240),
                    focusedBorderColor = Color(207, 6, 240)
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val checkedState = remember { mutableStateOf(false) }
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    modifier = Modifier
                        .scale(scale = 1.6f)
                        .size(40.dp)
                        .padding(16.dp),
                    colors = CheckboxDefaults.colors(checkedColor = Color(207,1,240) ),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = stringResource(id = R.string.over18),
                    fontSize = 16.sp
                )
            }
        }
    }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(15.dp, 0.dp),
            colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.createAccount).
                uppercase(),
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold

            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = stringResource(id = R.string.have_account))
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(id = R.string.signin),
                modifier = Modifier.clickable {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                },
                color = Color(207, 6, 240),
                fontWeight = FontWeight.Bold)
        }
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            BottomShape()
        }

    }
}