package com.cesar.reto_apuesta_total.presentation.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cesar.reto_apuesta_total.MainActivity
import com.cesar.reto_apuesta_total.R
import com.cesar.reto_apuesta_total.viewmodel.LoginViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    onHistory:()->Unit
){
    val stateElements = viewModel.stateElements
    val context = LocalContext.current
    val activity = (LocalContext.current as MainActivity)
    activity.softInputUnspecified()

    val user by remember {
        mutableStateOf("")
    }

    val password by remember {
        mutableStateOf("")
    }

    var userColorString by remember {
        mutableStateOf("b")
    }

    var passwordColorString by remember {
        mutableStateOf("b")
    }



    val interactionSourceUser = remember { MutableInteractionSource() }
    val isFocusedUser by interactionSourceUser.collectIsFocusedAsState()

    val interactionSourcePassword = remember { MutableInteractionSource() }
    val isFocusedPassword by interactionSourcePassword.collectIsFocusedAsState()

    val IndicatorUnfocusedWidth = 1.dp
    val IndicatorFocusedWidth = 3.dp
    val TextFieldPadding = 16.dp

    val userColor = if (userColorString == "b"){Color.Black}else{Color.Red}
    val passwordColor = if (passwordColorString == "b"){Color.Black}else{Color.Red}

    val indicatorWidthUser = if (isFocusedUser) IndicatorFocusedWidth else IndicatorUnfocusedWidth
    val fontSizeLabelUser = if (isFocusedUser || user.isNotEmpty()) 12.sp else 18.sp
    val indicatorWidthPassword = if (isFocusedPassword) IndicatorFocusedWidth else IndicatorUnfocusedWidth
    val fontSizeLabelPassword = if (isFocusedPassword || password.isNotEmpty()) 12.sp else 18.sp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val scope = rememberCoroutineScope()
        Text(
            text = "Bienvenido a",
            fontSize = 25.sp,
            style = TextStyle(color = Color.Black),
            textAlign = TextAlign.Center
        )
        Image(
            modifier = Modifier.width(400.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            modifier = Modifier.width(45.dp),
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = "logo_user"
        )
        Text(
            text = "Inicia Sesión",
            fontSize = 18.sp,
            style = TextStyle(color = Color.Black),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(35.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .drawBehind {
                    val strokeWidth = indicatorWidthUser.value * density
                    val y = (size.height - strokeWidth / 2) - 15
                    drawLine(
                        userColor,
                        Offset(TextFieldPadding.toPx(), y),
                        Offset(size.width - TextFieldPadding.toPx(), y),
                        strokeWidth
                    )
                }
            ,
            value = stateElements.email,
            onValueChange = {
                viewModel.changeEmail(it)
            },
            enabled = true,
            interactionSource = interactionSourceUser,
            textStyle = TextStyle(
                color = userColor,
                fontSize = 18.sp
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor =  Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            label = {
                Text(
                    text = "Usuario o Email",
                    color = userColor,
                    fontSize = fontSizeLabelUser
                )
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(40.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .drawBehind {
                    val strokeWidth = indicatorWidthPassword.value * density
                    val y = (size.height - strokeWidth / 2) - 15
                    drawLine(
                        passwordColor,
                        Offset(TextFieldPadding.toPx(), y),
                        Offset(size.width - TextFieldPadding.toPx(), y),
                        strokeWidth
                    )
                }
            ,
            value = stateElements.password,
            onValueChange = {
                viewModel.changePassword(it)
            },
            enabled = true,
            interactionSource = interactionSourcePassword,
            textStyle = TextStyle(
                color = passwordColor,
                fontSize = 18.sp
            ),
            visualTransformation =  PasswordVisualTransformation(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor =  Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            label = {
                Text(
                    "Contraseña",
                    color = passwordColor,
                    fontSize = fontSizeLabelPassword
                )
            },
            trailingIcon = {

            },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(horizontal = 30.dp),
            shape = RoundedCornerShape(10),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            onClick = {
                viewModel.login()
            }
        ) {
            Text(
                text = "INGRESA",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp
                )
            )
        }
        Spacer(modifier = Modifier.height(50.dp))


        LaunchedEffect(Unit){
            viewModel.uiState.collect{
                when(it){
                    is LoginUiState.Error -> {
                        val result = it.message
                        if (result.status==2){
                            userColorString = "r"
                            passwordColorString = "b"
                        }else{
                            passwordColorString = "r"
                            userColorString = "b"
                        }
                    }
                    is LoginUiState.Loading -> {

                    }
                    is LoginUiState.Success -> {
                        passwordColorString = "b"
                        userColorString = "b"
                        viewModel.cleanFields()
                        onHistory()
                    }
                    is LoginUiState.Nothing -> {

                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview(){

}