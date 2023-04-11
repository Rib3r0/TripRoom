package br.senai.sp.jandira.triproom.gui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.components.BottomShape
import br.senai.sp.jandira.triproom.components.TopShape
import br.senai.sp.jandira.triproom.model.User
import br.senai.sp.jandira.triproom.repository.UserRepository
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
    var emailState by remember{ mutableStateOf("") }
    var passwordState by remember{ mutableStateOf("") }
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

        //Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 0.dp)
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
                text = stringResource(id = R.string.please),
                fontSize = 19.sp,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily(Font(R.font.poppins)),
                lineHeight = 90.sp,
                color = Color(160, 156, 156)

            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {


            //Main
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                OutlinedTextField(
                    value = emailState,
                    onValueChange = {newEmail -> emailState = newEmail},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
            }
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                OutlinedTextField(
                    value = passwordState,
                    onValueChange = {newPassword -> passwordState = newPassword},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation(),
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
            }
            Spacer(
                modifier = Modifier.height(30.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        verifyUser(
                            email = emailState,
                            password = passwordState,
                            context = context
                        )


                    },
                    colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                    shape = RoundedCornerShape(16.dp)

                ) {
                    Text(
                        text = stringResource(id = R.string.signin),
                        fontSize = 16.sp,
                        fontWeight =  FontWeight.Bold,
                        color = Color.White

                    )
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_forward_24),
                        contentDescription ="",
                        tint = Color.White
                    )
                }
            }



        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = stringResource(id = R.string.dont_have))
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(id = R.string.signup),
                modifier = Modifier.clickable {
                    val intent = Intent(context, SignUpActivity::class.java)
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

fun verifyUser(
    email: String,
    password: String,
    context: Context
) {

    //criando um instancia no repositório
    val userRepository = UserRepository(context)

    //verificar se o usuario já existe
    val user = userRepository.validatePassword(email,password)
    Log.i("ds2m", "${user.toString()}")

    //salvar o usuario

    if (user == null){
        Toast.makeText(context, "email or password wrong!", Toast.LENGTH_SHORT).show()
    }else{
        val intent = Intent(context, HomeActivity::class.java)
        context.startActivity(intent)
    }

}