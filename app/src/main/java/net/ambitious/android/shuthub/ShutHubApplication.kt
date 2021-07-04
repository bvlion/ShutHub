package net.ambitious.android.shuthub

import android.app.Application
import com.google.android.gms.ads.MobileAds
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics

class ShutHubApplication : Application() {
  override fun onCreate() {
    super.onCreate()

    if (FirebaseApp.getApps(this).isNotEmpty()) {
//      RemoteConfigUtils.init()
    }

    MobileAds.initialize(this)

    FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
  }
}