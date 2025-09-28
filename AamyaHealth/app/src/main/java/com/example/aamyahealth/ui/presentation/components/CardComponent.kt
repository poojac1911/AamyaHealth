package com.example.aamyahealth.ui.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.aamyahealth.R

@Composable
fun UpcomingAppointmentCardComponent (
    modifier: Modifier = Modifier,
    image: Painter = painterResource(id = R.drawable.avatar_doctor_1),
    doctorName: String = "Dr. John Doe",
    doctorSpeciality: String = "Dermatologist Specialist",
    scheduleTime: String = "20 September - 12:30 - 10:30 PM"
){
    Card(
        modifier = modifier,
        colors =  CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = image,
                contentDescription = "Card Image",
                modifier = Modifier.size(46.dp).clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column (
                modifier = Modifier.weight(0.6f).padding(start = 12.dp),
            ){
                Text(
                    modifier = Modifier,
                    text = doctorName,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    modifier = Modifier,
                    text = doctorSpeciality,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            ImageButtonComponent(
                modifier = Modifier,
                onClick = { /*TODO*/ },
                icon = painterResource(R.drawable.chat_icon),
                colors = IconButtonColors(
                    containerColor = Color(0xFF407CE2).copy(alpha = 0.1f),
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.DarkGray
                )
            )
            IconButtonComponent(
                modifier = Modifier,
                onClick = { /*TODO*/ },
                icon = Icons.Default.Call,
                tint = Color(0xFF40A6FF),
                colors = IconButtonColors(
                    containerColor = Color(0xFF407CE2).copy(alpha = 0.1f),
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.DarkGray
                )
            )
        }

        Button(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray.copy(alpha = 0.2f),
                contentColor = Color.Black.copy(alpha = 0.6f
                )
            )
        ) {
            Text(text = scheduleTime)
        }
    }
}

@Preview
@Composable
fun WeekDayCardComponent(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit = {}
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        content()
    }
}

@Preview
@Composable
fun WeekCardComponent(
    modifier : Modifier = Modifier,
    colors: CardColors = CardDefaults.cardColors(
        containerColor = Color.White,
        contentColor = Color.Black.copy(alpha = 0.6f),
    ),
    onDaySelected :() -> Unit = {},
    date : String = "23",
    day : String = "Mon"
) {
    Card(
        modifier = modifier,
        colors = colors,
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(36.dp),
        onClick = onDaySelected
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = 12.dp).align(Alignment.CenterHorizontally),
            text = day,
            style = MaterialTheme.typography.labelSmall,
            fontSize = 12.sp,
        )
        Spacer(modifier = Modifier.height(4.dp))
        NeumorphicCircle(
            modifier = Modifier.zIndex(1f).align(Alignment.CenterHorizontally).padding(4.dp).size(36.dp),
            content = {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = date,
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
        )
    }
}

@Preview
@Composable
fun DoctorCardComponent(
    modifier : Modifier = Modifier.size(110.dp, 120.dp),
    doctorImage: Int = R.drawable.ic_launcher_background,
    doctorName: String = "Ralph Edward",
    doctorSpeciality: String = "Dental Specialist",
    rating: String = "4.5",
    colors: CardColors = CardDefaults.cardColors(
        containerColor = Color.White,
        contentColor = Color.Black,
    )
) {
    Card(
        modifier = modifier
            /*.shadow(
                elevation = 4.dp,
                shape = CircleShape,
                ambientColor = Color.White.copy(alpha = 0.7f),
                spotColor = Color.LightGray.copy(alpha = 0.15f),
                clip = false
            )*/,
        colors = colors,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = MaterialTheme.shapes.large
    ) {

        Row(
            modifier = Modifier.width(110.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = doctorImage),
                contentDescription = "Card Image",
                modifier = Modifier.padding(8.dp).size(40.dp).clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
                    .background(Color.Gray.copy(alpha = 0.2f)),
            ) {
                Row(
                    Modifier.padding(2.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        modifier = Modifier.size(16.dp),
                        tint = Color.Yellow,
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier,
                        text = rating,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = doctorName,
            fontSize = 12.sp,
            style = MaterialTheme.typography.titleSmall,
        )
        Text(
            modifier = Modifier.padding(start = 8.dp,bottom = 8.dp),
            text = doctorSpeciality,
            style = MaterialTheme.typography.labelSmall,
            fontSize = 10.sp
        )
    }
}


@Preview
@Composable
fun NeumorphicCircle(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Gray.copy(alpha = 0.2f),
    content: @Composable BoxScope.() -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .border(
                0.5.dp,
                brush = Brush.horizontalGradient(
                    colors = listOf(Color.White, Color.LightGray)
                ),
                shape = CircleShape
            )
            .shadow(
                elevation = 8.dp,
                shape = CircleShape,
                ambientColor = Color.White.copy(alpha = 0.7f),
                spotColor = Color.LightGray.copy(alpha = 0.15f),
                clip = false
            ),
        content = content,
    )
}

@Preview
@Composable
fun TitleCardComponent(
    modifier: Modifier = Modifier,
    title: String = "Title",
    seeClick: () -> Unit = {}
) {
    Row (
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            modifier = Modifier,
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 18.sp
        )
        Text(
            modifier = Modifier.clickable(
                role = Role.Button,
                onClick = seeClick
            ),
            text = "See All",
            style = MaterialTheme.typography.labelSmall,
            fontSize = 14.sp,
            color = Color.Black.copy(alpha = 0.6f)
        )
    }
}


@Preview
@Composable
fun TypeCardComponent(
    modifier: Modifier = Modifier,
    title: String = "Title",
    seeClick: () -> Unit = {},
    icon : Painter = painterResource(R.drawable.ic_launcher_background),
    color: Color = MaterialTheme.colorScheme.primary
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
        ),
        shape = RoundedCornerShape(36.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ){
        Row(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = icon,
                contentDescription = "icon",
                modifier = Modifier.background(
                    color = color.copy(alpha = 0.4f),
                    shape = CircleShape
                ).padding(8.dp).size(20.dp).clip(CircleShape),
            )
            Text(
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 14.sp
            )
        }
    }
}

