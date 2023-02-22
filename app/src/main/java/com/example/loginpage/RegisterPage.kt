package com.example.loginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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

    var showPassword by remember {
        mutableStateOf(false)
    }

    var confirmPasswordValue by remember{
        mutableStateOf("")
    }

    var showConfirmPassword by remember {
        mutableStateOf(false)
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
                            //.scrollable(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            color = colorResource(id = R.color.eulirio_purple_text_color),
                            text = stringResource(id = R.string.your_data),
                            style = MaterialTheme.typography.h2
                        )

                        OutlinedTextField(
                            value = userValue,
                            onValueChange = {
                                userValue = it;
                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 24.dp, top = 12.dp, end = 24.dp),
                            shape = RoundedCornerShape(12.dp),
                            textStyle = TextStyle(fontSize = 12.sp),

                            label = {
                                Text(
                                    text = stringResource(id = R.string.user_name),
                                    style = TextStyle (fontWeight = FontWeight.Light)
                                )
                            },

                            leadingIcon = {
                                Icon(
                                    Icons.Outlined.Email,
                                    contentDescription = "Icone de e-mail",
                                    modifier = Modifier.height(16.dp),
                                    tint = colorResource(id = R.color.eulirio_purple_text_color_border)
                                )
                            },

                            keyboardOptions =  KeyboardOptions(
                                imeAction = ImeAction.Next
                            ),
                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = emailValue,
                            onValueChange = {
                                emailValue = it;
                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 24.dp, end = 24.dp),
                            shape = RoundedCornerShape(12.dp),
                            textStyle = TextStyle(fontSize = 12.sp),

                            label = {
                                Text(
                                    text = stringResource(id = R.string.email_name),
                                    style = TextStyle (fontWeight = FontWeight.Light)
                                )
                            },

                            leadingIcon = {
                                Icon(
                                    Icons.Outlined.Email,
                                    contentDescription = "Icone de e-mail",
                                    modifier = Modifier.height(16.dp),
                                    tint = colorResource(id = R.color.eulirio_purple_text_color_border)
                                )
                            },

                            keyboardOptions =  KeyboardOptions(
                                imeAction = ImeAction.Next
                            ),
                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = passwordValue,
                            onValueChange = {
                                passwordValue = it;
                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 24.dp, end = 24.dp),
                            shape = RoundedCornerShape(12.dp),
                            textStyle = TextStyle(fontSize = 12.sp),

                            label = {
                                Text(
                                    text = stringResource(id = R.string.password_name),
                                    style = TextStyle (fontWeight = FontWeight.Light)
                                )
                            },

                            leadingIcon = {
                                Icon(
                                    Icons.Outlined.Lock,
                                    contentDescription = "Icone de cadeado",
                                    modifier = Modifier.height(16.dp),
                                    tint = colorResource(id = R.color.eulirio_purple_text_color_border)
                                )
                            },

                            trailingIcon = {
                                IconButton(onClick = { showPassword = !showPassword }) {
                                    Icon(
                                        modifier = Modifier.height(16.dp),
                                        contentDescription = if (showPassword) "Show Password" else "Hide Password",
                                        imageVector = if (showPassword) Icons.Outlined.Email else Icons.Outlined.Lock,
                                        tint = colorResource(id = R.color.eulirio_purple_text_color_border)
                                    )
                                }
                            },

                            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),

                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = confirmPasswordValue,
                            onValueChange = {
                                confirmPasswordValue = it;
                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 24.dp, end = 24.dp),
                            shape = RoundedCornerShape(12.dp),
                            textStyle = TextStyle(fontSize = 12.sp),

                            label = {
                                Text(
                                    text = stringResource(id = R.string.password_name_confirm),
                                    style = TextStyle (fontWeight = FontWeight.Light)
                                )
                            },

                            leadingIcon = {
                                Icon(
                                    Icons.Outlined.Lock,
                                    contentDescription = "Icone de cadeado",
                                    modifier = Modifier.height(16.dp),
                                    tint = colorResource(id = R.color.eulirio_purple_text_color_border)
                                )
                            },

                            trailingIcon = {
                                IconButton(onClick = { showConfirmPassword = !showConfirmPassword }) {
                                    Icon(
                                        modifier = Modifier.height(16.dp),
                                        contentDescription = if (showConfirmPassword) "Show Password" else "Hide Password",
                                        imageVector = if (showConfirmPassword) Icons.Outlined.Email else Icons.Outlined.Lock,
                                        tint = colorResource(id = R.color.eulirio_purple_text_color_border)
                                    )
                                }
                            },

                            visualTransformation = if (showConfirmPassword) VisualTransformation.None else PasswordVisualTransformation(),

                            singleLine = true
                        )

                        Spacer(modifier = Modifier.height(24.dp))

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