package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.weatherapp.R
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeatherData?.let { weatherData ->
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today ${weatherData.time.format(DateTimeFormatter.ofPattern("HH:mm"))}",
                    modifier = Modifier.align(Alignment.End),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = weatherData.weatherType.iconRes),
                    contentDescription = "Weather Type",
                    modifier = Modifier.width(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${weatherData.temperatureCelcius} °C",
                    fontSize = 50.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = weatherData.weatherType.weatherDesc,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherDetailDisplay(
                        value = weatherData.pressure.roundToInt(),
                        unit = "hpa",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                        contentDescription = "Pressure",
                        iconTint = Color.White,
                        textStyle = TextStyle(Color.White)
                    )
                    WeatherDetailDisplay(
                        value = weatherData.humidity.roundToInt(),
                        unit = "%",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                        contentDescription = "Humidity",
                        iconTint = Color.White,
                        textStyle = TextStyle(Color.White)
                    )
                    WeatherDetailDisplay(
                        value = weatherData.windSpeed.roundToInt(),
                        unit = "km/h",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                        contentDescription = "Pressure",
                        iconTint = Color.White,
                        textStyle = TextStyle(Color.White)
                    )
                }
            }
        }
    }
}