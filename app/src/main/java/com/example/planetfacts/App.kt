package com.example.planetfacts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image



val planetList = listOf(
    Planet("Mercury", R.drawable.mercury, listOf("Smallest planet in our Solar System", "Orbits the sun every 88 days")),
    Planet("Venus", R.drawable.venus, listOf("Hottest planet in our Solar System (despite not being the closest) at 900 F", "Similar in size to Earth")),
    Planet("Earth", R.drawable.earth, listOf("You are here!", "The only planet known to be able to sustain life")),
    Planet("Mars", R.drawable.mars, listOf("Has 2 small moons - Phobos and Deimos", "A martian day is called a 'Sol'")),
    Planet("Jupiter", R.drawable.jupiter, listOf("Largest planet in our solar system - bigger than every other planet combined", "Known for the 'great red spot' - a raging 350 year old storm")),
    Planet("Saturn", R.drawable.saturn, listOf("Known for its vibrant rings", "Has 146 recognized moons")),
    Planet("Uranus", R.drawable.uranus, listOf("Coldest planet in the solar system, with an average temperature of -371 F", "Spins on its side")),
    Planet("Neptune", R.drawable.neptune, listOf("The only planet that cannot be seen with the naked eye", "The densest of the gas giants")),
    Planet("Pluto", R.drawable.pluto, listOf("Was reclassified as a dwarf planet in 2006 by the International Astronomical Union", "Smaller than Russia in surface area"))

)

@Composable
fun App() {
    Scaffold { paddingValue ->
        Surface(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize(),
            color = Color.Black

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // App Title
                Text(
                    text = stringResource(id= R.string.app_title),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                    color = Color.White,
                )

                PlanetPager(planets = planetList)

            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlanetPager(planets: List<Planet>){
    val pagerState = rememberPagerState(pageCount = {planets.size})

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val planet = planets[page]
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = planet.imageResId),
                    contentDescription = planet.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                Text(
                    text = planet.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                planet.facts.forEach { fact ->
                    Text(
                        text = fact,
                        color = Color.White,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}