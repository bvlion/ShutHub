package net.ambitious.android.shuthub.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import net.ambitious.android.shuthub.R
import net.ambitious.android.shuthub.R.color
import net.ambitious.android.shuthub.R.drawable
import net.ambitious.android.shuthub.R.string

object BottomComponent {

  @Composable
  @ExperimentalMaterialApi
  fun AppBar(bottomSheetState: ModalBottomSheetState) {
    val selectedItem = remember { mutableStateOf(string.bottom_nav_history) }
    val scope = rememberCoroutineScope()

    BottomAppBar(
      Modifier
        .fillMaxWidth()
        .height(60.dp),
      backgroundColor = colorResource(R.color.amber_700),
      content = {
        BottomNavigation(
          Modifier
            .fillMaxWidth()
            .height(60.dp)
            .selectableGroup(),
          backgroundColor = colorResource(R.color.amber_700),
        ) {
          BottomNavigationItem(
            selectedItem,
            drawable.ic_bottom_liquor,
            string.bottom_nav_liquor
          ) {
            scope.launch {
              bottomSheetState.show()
            }
          }
          BottomNavigationItem(
            selectedItem,
            drawable.ic_bottom_edit,
            string.bottom_nav_edit
          ) {

          }
          BottomNavigationItem(
            selectedItem,
            drawable.ic_bottom_history,
            string.bottom_nav_history
          ) {

          }
          BottomNavigationItem(
            selectedItem,
            drawable.ic_bottom_share,
            string.bottom_nav_screen_shot
          ) {

          }
          BottomNavigationItem(
            selectedItem,
            drawable.ic_bottom_setting,
            string.bottom_nav_setting
          ) {

          }
        }
      }
    )
  }

  @Composable
  private fun RowScope.BottomNavigationItem(
    selectedItem: MutableState<Int>,
    imageRes: Int,
    stringRes: Int,
    onClick: () -> Unit
  ) =
    BottomNavigationItem(
      icon = {
        Icon(
          painterResource(imageRes),
          stringResource(stringRes),
          modifier = Modifier.padding(4.dp),
        )
      },
      label = { Text(stringResource(stringRes)) },
      selected = selectedItem.value == stringRes,
      onClick = {
        selectedItem.value = stringRes
        onClick()
      }
    )
}