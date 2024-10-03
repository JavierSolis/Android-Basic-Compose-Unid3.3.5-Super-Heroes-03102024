package codelab.javiersolis.i031024.superheros.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import codelab.javiersolis.i031024.superheros.Greeting
import codelab.javiersolis.i031024.superheros.R
import codelab.javiersolis.i031024.superheros.model.Hero
import codelab.javiersolis.i031024.superheros.model.HeroesRepository
import codelab.javiersolis.i031024.superheros.ui.theme.Shapes
import codelab.javiersolis.i031024.superheros.ui.theme.SuperheroesTheme


/**
 * Created by Javier J. Solis Flores on 3/10/24.
 * @email solis.unmsm@gmail.com
 * @github https://github.com/JavierSolis
 */
//create componible function to show card round corner
@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(
                id = R.color.background_card
            )
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp, start = 16.dp, end = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(72.dp)
        ){
            Column(
                modifier = Modifier
                    .weight(1f)
            ){
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = hero.imageRes),
                contentDescription = stringResource(id = hero.descriptionRes),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(72.dp)
                    .width(72.dp)
                    .clip(RoundedCornerShape(8.dp))

            )
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
            )
        }
    )
}

@Composable
fun HerosScreen(modifier: Modifier){
    Scaffold(
        topBar = {
            HeroTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(HeroesRepository.heroes) {
                HeroCard(
                    hero = it
                )
            }
        }
    }
}

//show preview HeroCard
@Preview(showBackground = true)
@Composable
fun HeroCardPreview() {
    SuperheroesTheme {
        HerosScreen(modifier = Modifier)
    }
}