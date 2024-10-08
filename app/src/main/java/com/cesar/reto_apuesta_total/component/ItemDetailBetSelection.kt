package com.cesar.reto_apuesta_total.component

import BetDetail
import BetSelection
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.graphics.green
import com.cesar.reto_apuesta_total.R

@Composable
fun ItemDetailBetSelection(betSelection: BetSelection) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (text1,text2,icon) = createRefs()
            Text(
                modifier = Modifier.constrainAs(text1){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
                text = betSelection.eventName?:""
            )

            if (betSelection.selectionStatus==1 || betSelection.selectionStatus==2){
                var tint = Color.Red
                var painterId = R.drawable.ic_cancel
                if (betSelection.selectionStatus==1){
                    tint = colorResource(id = R.color.green)
                    painterId = R.drawable.ic_check
                }
                Icon(
                    modifier = Modifier
                        .constrainAs(icon) {
                            top.linkTo(text1.top)
                            bottom.linkTo(text1.bottom)
                            start.linkTo(text1.end)
                            width = Dimension.value(20.dp)
                        }
                        .padding(start = 5.dp),
                    painter = painterResource(id = painterId),
                    tint = tint,
                    contentDescription =""
                )
            }



            Text(
                modifier = Modifier.constrainAs(text2){
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
                text = betSelection.price.toString()
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = betSelection.marketName?:"",
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(5.dp))
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (text1,text2) = createRefs()
            Text(
                modifier = Modifier.constrainAs(text1){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
                text = betSelection.eventName.toString(),
                fontSize = 14.sp
            )

            Text(
                modifier = Modifier.constrainAs(text2){
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
                text = betSelection.eventScore?:"",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = betSelection.eventDate?:"",
            fontSize = 14.sp
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ItemDetailBetSelectionPreview() {
//    ItemDetailBetSelection()
}