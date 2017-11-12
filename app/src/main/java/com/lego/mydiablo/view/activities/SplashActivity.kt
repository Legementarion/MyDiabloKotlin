package com.lego.mydiablo.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.crashlytics.android.Crashlytics
import com.lego.mydiablo.R
import io.fabric.sdk.android.Fabric
import android.content.Intent

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Fabric.with(this, Crashlytics())

        val intent = Intent(this, AuthorizationActivity::class.java)
        startActivity(intent)
        finish()
    }
}
