package com.cesar.reto_apuesta_total.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.cesar.reto_apuesta_total.R

@Composable
fun Filter(selectType:(String)->Unit,selectStatus:(String)->Unit) {
    val isDropDownExpandedType = remember {
        mutableStateOf(false)
    }

    val itemPositionType = remember {
        mutableStateOf(0)
    }

    val isDropDownExpandedStatus= remember {
        mutableStateOf(false)
    }

    val itemPositionStatus = remember {
        mutableStateOf(0)
    }

    val showContainerFilter= remember {
        mutableStateOf(false)
    }

    val typeList = listOf("Todos", "Simple", "Múltiple", "Sistema")
    val statusList = listOf("Todos", "Ganado", "Perdido", "Abierto")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(2.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(0.5.dp, Color.Gray),
    ) {

        Box(
            Modifier
                .fillMaxWidth()
                .height(35.dp)
                .background(
                    color = colorResource(id = R.color.red_at)
                ),

            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = 10.dp)
                ) {
                    val (text1,text2,icon) = createRefs()
                    Text(
                        modifier = Modifier.constrainAs(text1){
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                        },
                        text = "Filtrar",
                        color = Color.White,
                        fontSize = 16.sp
                    )

                    IconButton(
                        modifier = Modifier
                            .constrainAs(icon) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                end.linkTo(parent.end)
                            }
                            .width(50.dp),
                        onClick = {
                            showContainerFilter.value=!showContainerFilter.value
                    }) {
                        Image(
                            modifier = Modifier.width(50.dp),
                            colorFilter = ColorFilter.tint(color = Color.White),
                            imageVector = if(showContainerFilter.value){
                                Icons.Rounded.KeyboardArrowUp
                                                }else{
                                Icons.Rounded.KeyboardArrowDown
                            },
                            contentDescription = "detail"
                        )
                    }
                }
        }
        val density = LocalDensity.current
        AnimatedVisibility(
            visible = showContainerFilter.value,
            enter = slideInVertically {
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                expandFrom = Alignment.Top
            ) + fadeIn(
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ){
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text(
                        text = "Tipo : ",
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Card(modifier = Modifier.clickable {
                        isDropDownExpandedType.value = true
                    },
                        border = BorderStroke(1.dp, color = Color.Red)
                    ) {
                        Row(
                            modifier = Modifier.padding(5.dp),
                        ) {
                            Text(
                                text = typeList.get(itemPositionType.value),
                                fontSize = 16.sp
                            )
                            Image(
                                modifier = Modifier.width(50.dp),
                                colorFilter = ColorFilter.tint(color = Color.Red),
                                imageVector = Icons.Rounded.ArrowDropDown,
                                contentDescription = "detail"
                            )
                        }
                    }
                    DropdownMenu(
                        expanded = isDropDownExpandedType.value,
                        onDismissRequest = {
                            isDropDownExpandedType.value = false
                        }) {
                        typeList.forEachIndexed { index, type ->
                            DropdownMenuItem(text = {
                                Text(text = type)
                            },
                                onClick = {
                                    isDropDownExpandedType.value = false
                                    itemPositionType.value = index
                                    selectType(typeList.get(itemPositionType.value))
                                })
                        }
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text(
                        text = "Estado : ",
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Card(modifier = Modifier.clickable {
                        isDropDownExpandedStatus.value = true
                    },
                        border = BorderStroke(1.dp, color = Color.Red)
                    ) {
                        Row(
                            modifier = Modifier.padding(5.dp),
                        ) {
                            Text(
                                text = statusList.get(itemPositionStatus.value),
                                fontSize = 16.sp
                            )
                            Image(
                                modifier = Modifier.width(50.dp),
                                colorFilter = ColorFilter.tint(color = Color.Red),
                                imageVector = Icons.Rounded.ArrowDropDown,
                                contentDescription = "detail"
                            )
                        }
                    }
                    DropdownMenu(
                        expanded = isDropDownExpandedStatus.value,
                        onDismissRequest = {
                            isDropDownExpandedStatus.value = false
                        }) {
                        statusList.forEachIndexed { index, status ->
                            DropdownMenuItem(text = {
                                Text(text = status)
                            },
                                onClick = {
                                    isDropDownExpandedStatus.value = false
                                    itemPositionStatus.value = index
                                    selectStatus(statusList.get(itemPositionStatus.value))
                                })
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun FilterPreview() {

}