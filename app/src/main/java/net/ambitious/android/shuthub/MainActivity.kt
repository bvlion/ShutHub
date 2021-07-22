package net.ambitious.android.shuthub

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.ambitious.android.shuthub.R.color
import net.ambitious.android.shuthub.ui.component.AdMobComponent
import net.ambitious.android.shuthub.ui.component.BottomComponent
import net.ambitious.android.shuthub.ui.theme.Theme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Theme.ShutHubTheme {
        Surface(color = MaterialTheme.colors.background) {
          MainContent()
        }
      }
    }
  }
}

@Composable
fun MainContent(isPreview: Boolean = false) {
  Scaffold(
    topBar = {
      if (isPreview) {
        Box(
          modifier = Modifier
            .height(65.dp)
            .background(colorResource(color.amber_200_back))
            .fillMaxWidth(),
          contentAlignment = Alignment.Center,
        ) {
          Text(stringResource(R.string.ad_load))
        }
      } else {
        AdMobComponent.AdView(LocalContext.current as Activity)
      }
    },
    content = {
      Column {
        Box(
          Modifier.fillMaxSize()
        ) {
          Text(
            text = "めいんのこんてんつ",
            fontSize = 22.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.align(Alignment.Center)
          )
        }
      }
    },
    bottomBar = { BottomComponent.AppBar() }
  )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  Theme.ShutHubTheme {
    MainContent(true)
  }
}
