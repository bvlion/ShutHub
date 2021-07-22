package net.ambitious.android.shuthub.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import net.ambitious.android.shuthub.ui.theme.Shape.Shapes

object Theme {
  private val DarkColorPalette = darkColors(
    primary = Color.Amber200,
    primaryVariant = Color.Amber700,
    secondary = Color.Teal200
  )

  private val LightColorPalette = lightColors(
    primary = Color.Amber500,
    primaryVariant = Color.Amber700,
    secondary = Color.Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
  )

  private val Typography = Typography(
    body1 = TextStyle(
      fontFamily = FontFamily.Default,
      fontWeight = FontWeight.Normal,
      fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
  )

  @Composable
  fun ShutHubTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
      DarkColorPalette
    } else {
      LightColorPalette
    }

    MaterialTheme(
      colors = colors,
      typography = Typography,
      shapes = Shapes,
      content = content
    )
  }
}