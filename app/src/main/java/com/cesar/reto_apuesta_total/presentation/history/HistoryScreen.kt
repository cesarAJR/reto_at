package com.cesar.reto_apuesta_total.presentation.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.sharp.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cesar.reto_apuesta_total.MainActivity
import com.cesar.reto_apuesta_total.R
import com.cesar.reto_apuesta_total.component.Filter
import com.cesar.reto_apuesta_total.component.ItemBet
import com.cesar.reto_apuesta_total.component.ItemDetailBet
import com.cesar.reto_apuesta_total.viewmodel.HistoryViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(viewModel:HistoryViewModel= koinViewModel(),onLogin:()->Unit){
    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    LaunchedEffect( true){
        viewModel.getHistory()
    }

    if (sheetState.isVisible) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                scope.launch {
                    sheetState.hide()
                }
            },
        ) {
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                Box {
                    viewModel.stateElements.detail?.let { viewModel.stateElements.bet?.let { it1 -> ItemDetailBet(betDetail = it, bet = it1) } }
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {

                },
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Image(

                            modifier = Modifier.width(200.dp),
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "logo"
                        )
                    }

                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.LightGray
                ),
                actions = {
                    Row{
                        Icon(
                            imageVector = Icons.Sharp.ExitToApp,
                            contentDescription = "logout",
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .clickable {
                                    onLogin()
                                    (context as MainActivity).logOut()
                                }
                        )
                    }

                }
            )
        },

    ) { it ->
        Surface(modifier = Modifier
            .padding(top = it.calculateTopPadding())
            .fillMaxSize()
        ) {
            Column {
                Box(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = viewModel.stateElements.search?:"",
                        onValueChange = {value->
                            viewModel.changeSearch(value)
                            viewModel.searchHistory()
                        },
                        placeholder = {
                                Text(
                                    text = "Buscar",
                                    fontSize = 16.sp
                                )
                        },
                        shape = RoundedCornerShape(20.dp,),
                        textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
                        trailingIcon = {
                            Icon(imageVector = Icons.Rounded.Search, contentDescription = "" )
                        }
                    )
                }

                Box(
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Filter(
                        {
                            var type = it
                            if(it == "Todos"){
                                type =""
                            }
                            viewModel.changeSelectType(type)
                            viewModel.searchHistory()
                        },
                        {
                            var status = it
                            if(it == "Todos"){
                                status =""
                            }
                            viewModel.changeSelectStatus(status)
                            viewModel.searchHistory()
                        }
                    )
                }

                Box(
                    Modifier.padding(top = 10.dp)
                ) {
                    LazyColumn(
                        contentPadding = PaddingValues(8.dp),
                    ) {
                        viewModel.stateElements.list?.let { bets ->
                            items(bets) { bet ->
                                ItemBet(bet) {
                                    viewModel.getDetailHistory(it)
                                    scope.launch {
                                        sheetState.expand()
                                    }
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(Unit){
        viewModel.uiState.collect{
            when(it){
                is HistoryUiState.Error -> {

                }
                is HistoryUiState.Nothing -> {

                }
                is HistoryUiState.Success -> {
                    it.list?.let {
                        viewModel.updateList(list = it)
                    }
                }

                is HistoryUiState.SuccessDetail -> {
                    it.data?.let {bd->
                        viewModel.updateDetail(detail = bd, it.bet)
                    }
                }

                is HistoryUiState.SuccessSearchHistory -> {
                    it.list?.let {
                        viewModel.updateList(list = it)
                    }
                }
            }
        }
    }

}