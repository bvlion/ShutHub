package net.ambitious.android.shuthub.ui.component

import android.app.Activity
import android.os.Build
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import net.ambitious.android.shuthub.BuildConfig
import net.ambitious.android.shuthub.R

object AdMobComponent {
  @Composable
  fun AdView(activity: Activity) {
    var layout: LinearLayout? = null
    var adView: AdView? = null

    val lifecycleObserver = remember {
      LifecycleEventObserver { _, event ->
        when (event) {
          Lifecycle.Event.ON_RESUME -> adView?.resume()
          Lifecycle.Event.ON_PAUSE -> adView?.pause()
          Lifecycle.Event.ON_DESTROY -> layout?.let {
            adView?.run {
              it.removeView(this)
              destroy()
            }
          }
          else -> Unit
        }
      }
    }

    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifecycle) {
      lifecycle.addObserver(lifecycleObserver)
      onDispose {
        lifecycle.removeObserver(lifecycleObserver)
      }
    }

    AndroidView({ it ->
      LinearLayout(it).also { layout ->
        layout.setBackgroundColor(ContextCompat.getColor(it, R.color.amber_200_back))
        layout.layoutParams = LinearLayout.LayoutParams(
          LinearLayout.LayoutParams.MATCH_PARENT,
          (65 * getOutMetrics(activity).density).toInt()
        )
        val text = TextView(it).apply {
          setText(R.string.ad_load)
          layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
          )
          gravity = Gravity.CENTER
        }
        layout.addView(text)
        adView = AdView(it).apply {
          adSize = getAdaptiveAdSize(activity, this)
          adUnitId = BuildConfig.AD_MOB_BANNER_KEY
          loadAd(AdRequest.Builder().build())
          adListener = object : AdListener() {
            override fun onAdLoaded() {
              super.onAdLoaded()
              layout.setBackgroundColor(ContextCompat.getColor(it, android.R.color.white))
              layout.removeView(text)
            }
          }
        }
        layout.addView(adView)
      }.also { layout = it }
    })
  }

  private fun getAdaptiveAdSize(activity: Activity, view: View): AdSize {
    val outMetrics = getOutMetrics(activity)

    var adWidthPixels = view.width.toFloat()
    if (adWidthPixels == 0f) {
      adWidthPixels = outMetrics.widthPixels.toFloat()
    }

    val adWidth = (adWidthPixels.div(outMetrics.density)).toInt().let {
      val adMaxWidth = 802
      if (it > adMaxWidth) {
        adMaxWidth
      } else {
        it
      }
    }
    return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(
      activity, adWidth
    )
  }

  private fun getOutMetrics(activity: Activity): DisplayMetrics {
    val outMetrics = DisplayMetrics()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
      activity.display?.getRealMetrics(outMetrics)
    } else {
      @Suppress("DEPRECATION")
      activity.windowManager?.defaultDisplay?.getRealMetrics(outMetrics)
    }
    return outMetrics
  }
}