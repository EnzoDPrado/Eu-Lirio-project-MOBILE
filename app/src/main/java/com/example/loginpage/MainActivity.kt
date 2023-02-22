package com.example.loginpage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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
import androidx.compose.material.Icon
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.core.content.ContextCompat.startActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    loginPage()
                }
            }
        }
    }
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun loginPage() {

    var emailValue by rememberSaveable {
        mutableStateOf("")
    }

    var passwordValue by remember {
        mutableStateOf("")
    }
    var showPassword by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

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
                        .padding(start = 24.dp, end = 24.dp)
                        .height(400.dp),
                    shape = RoundedCornerShape(50.dp),
                    elevation = 0.dp,
//                    backgroundColor = Color(0xFFF7F5EF)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 36.dp)
                            .fillMaxSize()
                            .background(Color(0x4DFFFCEA)),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            color = colorResource(id = R.color.eulirio_purple_text_color),
                            text = stringResource(id = R.string.login_name),
                            fontSize = 42.sp,
                            style = MaterialTheme.typography.h1
                        )

                        OutlinedTextField(
                            value = emailValue,
                            onValueChange = {
                                emailValue = it;
                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 24.dp, top = 12.dp, end = 24.dp),
                            textStyle = TextStyle(fontSize = 16.sp),

                            shape = RoundedCornerShape(12.dp),

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
                                    modifier = Modifier.height(24.dp),
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
                            textStyle = TextStyle(fontSize = 16.sp),

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
                                    modifier = Modifier.height(24.dp),
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

                        Spacer(modifier = Modifier.height(20.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(end = 30.dp)
                            ,
                            horizontalAlignment = Alignment.End,


                            ) {

                            Button(
                                onClick = {

                                },
                                modifier = Modifier
                                    .width(160.dp),
                                shape = RoundedCornerShape(30.dp),
                                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.eulirio_purple))


                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.login_name),
                                        color = colorResource(
                                            id = R.color.white
                                        ),
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )

                                }
                            }
                            Text(
                                modifier = Modifier
                                    .padding(top = 7.dp),
                                text = stringResource(id = R.string.does_have_account),
                                color = colorResource(id = R.color.black),
                                fontSize = 12.sp,
                            )
                            Text(
                                modifier = Modifier
                                    .clickable {
                                        val intent = Intent(context, RegisterPage::class.java)
                                        context.startActivity(intent)
                                    },
                                text = stringResource(id = R.string.sign_up_now),
                                color = colorResource(id = R.color.eulirio_purple_text_color),
                                fontSize = 13.sp,
                            )
//                            ClickableText(
//                                text = buildAnnotatedString {
//                                    withStyle(
//                                        style = SpanStyle(
//                                            color = colorResource(id = R.color.eulirio_purple_text_color)
//                                        )
//                                    ) {
//                                        append(stringResource(id = R.string.sign_up_now))
//                                    }
//                                }
//                            ) {
//                                val intent = Intent(context, RegisterPage::class.java)
//                                context.startActivity(intent)
//                            }
                        }

                    }

                }

            }

        }

    }

}


fun Text(text: String, Color: String) {

}


@Preview(showBackground = true)
@Composable
fun loginPagePreview() {
    loginPagePreview()
}