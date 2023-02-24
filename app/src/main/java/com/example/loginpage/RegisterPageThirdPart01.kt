package com.example.loginpage

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.ui.theme.LoginPageTheme

class RegisterPageThirdPart01 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    registerPageThirdPart()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun registerPageThirdPart() {

    val context = LocalContext.current

    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2)),
        verticalArrangement = Arrangement.SpaceBetween
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
                        .height(440.dp),
                    shape = RoundedCornerShape(50.dp),
                    elevation = 4.dp,
                    backgroundColor = Color.White
                ) {
                    Box(){
                        Column(
                            modifier = Modifier
                                .padding(bottom = 4.dp)
                        ) {
                            Column(
                            ) {
                                Text(
                                    text = "olá, [nome]".uppercase(),
                                    modifier = Modifier
                                        .padding(top = 40.dp)
                                        .fillMaxWidth(),
                                    color = colorResource(id = R.color.eulirio_purple_text_color),
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.h2
                                )

                                val descriptionP1 = stringResource(id = R.string.description_third_page_pt1)
                                val descriptionP2 = stringResource(id = R.string.description_third_page_pt2)
                                val descriptionP3 = stringResource(id = R.string.description_third_page_pt3)
                                val descriptionP4 = stringResource(id = R.string.description_third_page_pt4)
                                val descriptionP5 = stringResource(id = R.string.description_third_page_pt5)

                                Text(
                                    buildAnnotatedString {
                                        append("$descriptionP1 ")

                                        withStyle(style = SpanStyle(
                                            color = colorResource(id = R.color.eulirio_purple_text_color),
                                            fontWeight = FontWeight.W900
                                        )) {
                                            append("$descriptionP2 ")
                                        }

                                        append("$descriptionP3 ")

                                        withStyle(style = SpanStyle(
                                            color = colorResource(id = R.color.eulirio_purple_text_color),
                                            fontWeight = FontWeight.W900
                                        )) {
                                            append("$descriptionP4 ")
                                        }

                                        append(descriptionP5)
                                    },

                                    modifier = Modifier.padding(start = 48.dp, end = 48.dp),
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.body2,
                                )
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .verticalScroll(rememberScrollState()),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                LazyColumn(

                                ) {

                                }
                            }
                        }

                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .background(Color(0x80FFFFFF))
                                .fillMaxWidth()
                                .height(70.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .width(200.dp),
                                shape = RoundedCornerShape(30.dp),
                                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.eulirio_purple))
                            ) {
                                Text(
                                    text = stringResource(id = R.string.finish),
                                    color = colorResource(
                                        id = R.color.white
                                    ),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold
                                )

                            }
                        }
                    }
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun registerPageThirdPartPreview() {
    registerPageThirdPartPreview()
}