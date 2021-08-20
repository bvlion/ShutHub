package net.ambitious.android.shuthub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import net.ambitious.android.shuthub.ui.component.MainContent
import net.ambitious.android.shuthub.ui.theme.Theme
import androidx.compose.foundation.lazy.LazyColumn as LazyColumn

class MainActivity : ComponentActivity() {
  @ExperimentalMaterialApi
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Theme.ShutHubTheme {
        Surface(color = MaterialTheme.colors.background) {
          Main()
        }
      }
    }
  }

  @Composable
  @ExperimentalMaterialApi
  fun Main() {
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
      sheetState = bottomSheetState,
      sheetContent = {
        LazyColumn {
          items(25) {
            ListItem(
              text = { Text("Item $it") },
              icon = {
                Icon(
                  Icons.Default.Favorite,
                  contentDescription = "Localized description"
                )
              }
            )
          }
        }
      }
    ) {
      MainContent(bottomSheetState)
    }
  }
}