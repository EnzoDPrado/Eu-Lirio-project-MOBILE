package com.example.loginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.ui.theme.LoginPageTheme

class RegisterPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    registerPage()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun registerPage() {


    var userValue by remember{
        mutableStateOf("")
    }

    var emailValue by rememberSaveable {
        mutableStateOf("")
    }

    var passwordValue by remember {
        mutableStateOf("")
    }

    var confirmPasswordValue by remember{
        mutableStateOf("")
    }


    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.logoeulirio),
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .width(178.dp)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Card(
                    modifier = Modifier
                        .height(445.dp)
                        .width(325.dp),
                    shape = RoundedCornerShape(50.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 40.dp, bottom = 45.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            color = colorResource(id = R.color.eulirio_purple_text_color),
                            text = stringResource(id = R.string.your_data),
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                        )
                        OutlinedTextField(
                            value = userValue, onValueChange = {
                                userValue = it;
                            },
                            modifier = Modifier
                                .height(53.dp)
                                .width(240.dp),
                            shape = RoundedCornerShape(12.dp),
                            textStyle = TextStyle(fontSize = 12.sp),
                            label = {
                                Text(text = stringResource(id = R.string.user_name), fontSize = 13.sp)
                            }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedTextField(
                            value = emailValue, onValueChange = {
                                emailValue = it;
                            },
                            modifier = Modifier
                                .height(53.dp)
                                .width(240.dp),
                            shape = RoundedCornerShape(12.dp),
                            textStyle = TextStyle(fontSize = 12.sp),
                            label = {
                                Text(text = stringResource(id = R.string.email_name), fontSize = 13.sp)
                            }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedTextField(
                            value = passwordValue, onValueChange = {
                                passwordValue = it;
                            },
                            modifier = Modifier
                                .height(53.dp)
                                .width(240.dp),
                            shape = RoundedCornerShape(12.dp),
                            textStyle = TextStyle(fontSize = 12.sp),
                            label = {
                                Text(text = stringResource(id = R.string.password_name), fontSize = 13.sp)
                            }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedTextField(
                            value = confirmPasswordValue, onValueChange = {
                                confirmPasswordValue = it;

                            },
                            modifier = Modifier
                                .height(53.dp)
                                .width(240.dp),
                            shape = RoundedCornerShape(12.dp),
                            textStyle = TextStyle(fontSize = 12.sp),
                            label = {
                                Text(text = stringResource(id = R.string.password_name_confirm), fontSize = 13.sp)
                            }

                        )

                        Spacer(modifier = Modifier.height(20.dp))


                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                                .width(160.dp)
                                .height(34.dp),
                            shape = RoundedCornerShape(30.dp),
                            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.eulirio_purple))


                        ) {
                            Text(
                                text = stringResource(id = R.string.advance),
                                color = colorResource(
                                    id = R.color.white
                                )
                            )
                        }


                    }


                }


            }

        }

    }

}


@Preview(showBackground = true)
@Composable
fun registerPagePreview() {
    registerPagePreview()
}