package net.ambitious.android.shuthub.ui.component

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue.Hidden
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
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
import net.ambitious.android.shuthub.R.string
import net.ambitious.android.shuthub.ui.theme.Theme

@Composable
@ExperimentalMaterialApi
fun MainContent(bottomSheetState: ModalBottomSheetState, isPreview: Boolean = false) {
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
          Text(stringResource(string.ad_load))
        }
      } else {
        AdMobComponent.AdView(LocalContext.current as Activity)
      }
    },
    content = {
      GrassComponent.Content()
    },
    bottomBar = { BottomComponent.AppBar(bottomSheetState) }
  )
}

@Preview(showBackground = true)
@Composable
@ExperimentalMaterialApi
fun DefaultPreview() {
  Theme.ShutHubTheme {
    MainContent(rememberModalBottomSheetState(Hidden), true)
  }
}
