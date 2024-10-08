package com.cesar.reto_apuesta_total.component

import BetDetail
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
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.cesar.domain.model.Bet
import com.cesar.reto_apuesta_total.R
import com.cesar.reto_apuesta_total.util.changeFormatDate
import com.cesar.reto_apuesta_total.util.changeLanguageStatus
import com.cesar.reto_apuesta_total.util.changeLanguageType

@Composable
fun ItemDetailBet(betDetail:BetDetail,bet:Bet) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(2.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(0.5.dp, Color.Gray),
    ) {

        ConstraintLayout(
            Modifier
                .fillMaxWidth()
                .height(35.dp)
                .background(
                    color = colorResource(id = R.color.red_at)
                ),

            ) {
                val (text1,text2) = createRefs()
                Text(
                    modifier = Modifier
                        .constrainAs(text1) {
                            bottom.linkTo(parent.bottom)
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .padding(start = 10.dp),
                    text = changeLanguageType(bet.type),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )

            Text(
                    modifier = Modifier
                        .constrainAs(text2) {
                            bottom.linkTo(parent.bottom)
                            top.linkTo(parent.top)
                            end.linkTo(parent.end)
                        }
                        .padding(end = 10.dp),
                    text = changeLanguageStatus(bet.status),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
            }

        Box(
            Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray))
        {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)

            ) {
                betDetail.betSelections?.forEach {
                    ItemDetailBetSelection(it)
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            ConstraintLayout(
                modifier = Modifier.fillMaxWidth()
            ) {
                val (text1,text2) = createRefs()
                Text(
                    modifier = Modifier.constrainAs(text1){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                    text = "Monto total",
                    fontSize = 14.sp
                )

                Text(
                    modifier = Modifier.constrainAs(text2){
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    },
                    text = "${betDetail.totalStake?:""} PEN" ,
                    fontSize = 14.sp
                )
            }
            ConstraintLayout(
                modifier = Modifier.fillMaxWidth()
            ) {
                val (text1,text2) = createRefs()
                Text(
                    modifier = Modifier.constrainAs(text1){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                    text = "Ganancia total",
                    fontSize = 14.sp
                )

                Text(
                    modifier = Modifier.constrainAs(text2){
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    },
                    text = "${betDetail.totalWin?:""} PEN" ,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }

}

@Composable
@Preview(showBackground = true)
fun ItemDetailBetPreview() {
//    ItemDetailBet()
}