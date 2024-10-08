package com.cesar.reto_apuesta_total.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.cesar.domain.model.Bet
import com.cesar.reto_apuesta_total.R
import com.cesar.reto_apuesta_total.util.changeFormatDate
import com.cesar.reto_apuesta_total.util.changeLanguageStatus
import com.cesar.reto_apuesta_total.util.changeLanguageType
import kotlinx.coroutines.launch

@Composable
fun ItemBet(bet: Bet,openDetail:(data:Bet)->Unit) {
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
                    IconButton(onClick = {
                        openDetail(bet)
                    }) {
                        Image(
                            colorFilter = ColorFilter.tint(color = Color.White),
                            painter = painterResource(id = R.drawable.ic_eye),
                            contentDescription = "detail"
                        )
                    }

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                        ) {
                        Text(
                            text = bet.game,
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        )
                        }
                }




        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp)

        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Text(
                    text = "Fecha y Hora",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = changeFormatDate(bet.createdDate) ,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Monto",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "S/ ${(bet.wager/100)}" ,
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Resultado",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = changeLanguageStatus(bet.status) ,
                    fontSize = 14.sp,
                    color = if (bet.status == "LOST"){Color.Red}else{Color.Gray}
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Text(
                    text = "Tipo",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = changeLanguageType(bet.type) ,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Cuota",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = bet.odds.toString() ,
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Ganancia",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "S/ ${(bet.winning/100.0)}"  ,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
    }

@Composable
@Preview(showBackground = true)
fun ItemBetPreview(){
//    ItemBet(Bet(2,"#23323","2024-09-07 16:28:04","WON","d","d",200,1.2,100))
}