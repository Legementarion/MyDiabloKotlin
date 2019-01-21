package com.yalantis.coreui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.yalantis.coreui.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
