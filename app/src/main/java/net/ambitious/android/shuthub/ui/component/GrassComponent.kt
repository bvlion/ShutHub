package net.ambitious.android.shuthub.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import net.ambitious.android.shuthub.R
import kotlin.random.Random

object GrassComponent {
  @Composable
  @ExperimentalMaterialApi
  fun Content() {
    Box(
      Modifier
        .fillMaxSize()
    ) {
      LazyColumn(Modifier.padding(start = 16.dp, end = 16.dp, bottom = 64.dp)) {
        items(8) {
          if (it == 0) {
            Row(Modifier.fillMaxWidth()) {
              repeat(14) { row ->
                when (row) {
                  0 -> Text("4", Modifier.weight(1f).padding(start = 8.dp))
                  1 -> Text("5", Modifier.weight(1f).padding(start = 8.dp))
                  6 -> Text("6", Modifier.weight(1f).padding(start = 8.dp))
                  10 -> Text("7", Modifier.weight(1f).padding(start = 8.dp))
                  else -> Text("", Modifier.weight(1f).padding(start = 8.dp))
                }
              }
            }
            return@items
          }
          Row(Modifier.fillMaxWidth()) {
            repeat(14) {
              Box(
                Modifier
                  .weight(1f)
                  .height(26.dp)
                  .padding(1.dp)
                  .background(Color.Gray)
              ) {
                Box(
                  Modifier
                    .fillMaxSize()
                    .background(
                      when (Random.nextInt(0, 3)) {
                        0 -> colorResource(R.color.amber_200)
                        1 -> colorResource(R.color.amber_500)
                        2 -> colorResource(R.color.amber_700)
                        else -> colorResource(R.color.amber_500)
                      }
                    )
                )
              }
            }
          }
        }
      }
    }
  }
}