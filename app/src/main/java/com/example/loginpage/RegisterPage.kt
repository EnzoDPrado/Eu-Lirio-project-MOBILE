package com.example.loginpage

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
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

    val context = LocalContext.current

    val focusManager = LocalFocusManager.current

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

    var userErrorRequiredInput by remember {
        mutableStateOf(false)
    }

    var emailErrorRequiredInput by remember {
        mutableStateOf(false)
    }

    var passwordErrorRequiredInput by remember {
        mutableStateOf(false)
    }

    var confirmPasswordErrorRequiredInput by remember {
        mutableStateOf(false)
    }

    var colorIconUser = colorResource(id = R.color.eulirio_purple_text_color_border)

    var colorIconEmail = colorResource(id = R.color.eulirio_purple_text_color_border)

    var colorIconPassword = colorResource(id = R.color.eulirio_purple_text_color_border)

    var colorIconConfirmPassword = colorResource(id = R.color.eulirio_purple_text_color_border)

    val userFocusRequester = remember {
        FocusRequester()
    }

    val emailFocusRequester = remember {
        FocusRequester()
    }

    val passwordFocusRequester = remember {
        FocusRequester()
    }

    val confirmPasswordFocusRequester = remember {
        FocusRequester()
    }

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
                        .height(400.dp),
                    shape = RoundedCornerShape(50.dp),
                    elevation = 4.dp,
                    backgroundColor = Color.White
                ) {
                    Column(
                        modifier = Modifier.padding(bottom = 40.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.your_data),
                            modifier = Modifier
                                .padding(top = 40.dp)
                                .fillMaxWidth(),
                            color = colorResource(id = R.color.eulirio_purple_text_color),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h2
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(rememberScrollState()),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            OutlinedTextField(
                                value = userValue,
                                onValueChange = {
                                    userValue = it;
                                },

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 24.dp, end = 24.dp)
                                    .focusRequester(userFocusRequester),
                                shape = RoundedCornerShape(12.dp),
                                textStyle = TextStyle(fontSize = 16.sp),

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
                                        modifier = Modifier.height(24.dp),
                                        tint = colorIconUser
                                    )
                                },

                                isError = userErrorRequiredInput,

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
                                    .padding(start = 24.dp, end = 24.dp)
                                    .focusRequester(emailFocusRequester),
                                shape = RoundedCornerShape(12.dp),
                                textStyle = TextStyle(fontSize = 16.sp),

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
                                        tint = colorIconEmail
                                    )
                                },

                                isError = emailErrorRequiredInput,

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
                                    .padding(start = 24.dp, end = 24.dp)
                                    .focusRequester(passwordFocusRequester),
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
                                        tint = colorIconPassword
                                    )
                                },

                                trailingIcon = {
                                    IconButton(onClick = { showPassword = !showPassword }) {
                                        Icon(
                                            modifier = Modifier.height(16.dp),
                                            contentDescription = if (showPassword) "Show Password" else "Hide Password",
                                            imageVector = if (showPassword) Icons.Outlined.Email else Icons.Outlined.Lock,
                                            tint = Color(0xFF010101)
                                        )
                                    }
                                },

                                isError = passwordErrorRequiredInput,

                                keyboardOptions =  KeyboardOptions(
                                    imeAction = ImeAction.Next
                                ),

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
                                    .padding(start = 24.dp, end = 24.dp)
                                    .focusRequester(confirmPasswordFocusRequester),
                                shape = RoundedCornerShape(12.dp),
                                textStyle = TextStyle(fontSize = 16.sp),

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
                                        modifier = Modifier.height(24.dp),
                                        tint = colorIconConfirmPassword
                                    )
                                },

                                trailingIcon = {
                                    IconButton(onClick = { showConfirmPassword = !showConfirmPassword }) {
                                        Icon(
                                            modifier = Modifier.height(16.dp),
                                            contentDescription = if (showConfirmPassword) "Show Password" else "Hide Password",
                                            imageVector = if (showConfirmPassword) Icons.Outlined.Email else Icons.Outlined.Lock,
                                            tint = Color(0xFF010101)
                                        )
                                    }
                                },

                                isError = confirmPasswordErrorRequiredInput,

                                visualTransformation = if (showConfirmPassword) VisualTransformation.None else PasswordVisualTransformation(),

                                keyboardOptions =  KeyboardOptions(
                                    imeAction = ImeAction.Done
                                ),
                                keyboardActions = KeyboardActions (
                                    onDone = {
                                        focusManager.clearFocus()
                                    }
                                ),

                                singleLine = true
                            )

                            if (userErrorRequiredInput || emailErrorRequiredInput || passwordErrorRequiredInput || confirmPasswordErrorRequiredInput) {
                                Text(
                                    modifier = Modifier
                                        .padding(top = 3.dp),
                                    text = stringResource(id = R.string.erro_message_input_required),
                                    color = Color(0xFFB00020),
                                    fontSize = 12.sp,
                                )
                            }

                            Spacer(modifier = Modifier.height(24.dp))

                            Button(
                                onClick = {
                                    if(userValue.isEmpty()) {
                                        userErrorRequiredInput = true
                                        colorIconUser = Color(0xFFB00020)
                                        userFocusRequester.requestFocus()
                                    }
                                    else userErrorRequiredInput = false

                                    if(emailValue.isEmpty()) {
                                        emailErrorRequiredInput = true
                                        colorIconEmail = Color(0xFFB00020)
                                        emailFocusRequester.requestFocus()
                                    }
                                    else emailErrorRequiredInput = false

                                    if(passwordValue.isEmpty()) {
                                        passwordErrorRequiredInput = true
                                        colorIconPassword = Color(0xFFB00020)
                                        passwordFocusRequester.requestFocus()
                                    }
                                    else passwordErrorRequiredInput = false

                                    if(confirmPasswordValue.isEmpty()) {
                                        confirmPasswordErrorRequiredInput = true
                                        colorIconConfirmPassword = Color(0xFFB00020)
                                        confirmPasswordFocusRequester.requestFocus()
                                    }
                                    else confirmPasswordErrorRequiredInput = false

                                    if (!userValue.isEmpty() && !emailValue.isEmpty() && !passwordValue.isEmpty() && !confirmPasswordValue.isEmpty()) {
                                        val intent = Intent(context, RegisterPageThirdPart::class.java)
                                        context.startActivity(intent)
                                    }
                                },
                                modifier = Modifier
                                    .width(200.dp),
                                shape = RoundedCornerShape(30.dp),
                                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.eulirio_purple))


                            ) {
                                Text(
                                    text = stringResource(id = R.string.advance),
                                    color = colorResource(
                                        id = R.color.white
                                    ),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            if(!userValue.isEmpty()) {
                                userErrorRequiredInput = false
                                colorIconUser = colorResource(id = R.color.eulirio_purple_text_color_border)
                            }

                            if(!emailValue.isEmpty()) {
                                emailErrorRequiredInput = false
                                colorIconEmail = colorResource(id = R.color.eulirio_purple_text_color_border)
                            }

                            if(!passwordValue.isEmpty()) {
                                passwordErrorRequiredInput = false
                                colorIconPassword = colorResource(id = R.color.eulirio_purple_text_color_border)
                            }

                            if(!confirmPasswordValue.isEmpty()) {
                                confirmPasswordErrorRequiredInput = false
                                colorIconConfirmPassword = colorResource(id = R.color.eulirio_purple_text_color_border)
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
fun registerPagePreview() {
    registerPagePreview()
}