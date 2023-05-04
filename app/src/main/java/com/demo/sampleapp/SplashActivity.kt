package com.demo.sampleapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.demo.sampleapp.databinding.ActivitySplashBinding
import timber.log.Timber

class SplashActivity : AppCompatActivity() {

    private var splashActivityBinding: ActivitySplashBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate")
        splashActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)


        Handler().postDelayed({

           /* if (SharedPref.isUserSignIn()!!) {*/
                val intent = Intent(this, BaseActivity::class.java)
                startActivity(intent)
            /*} else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }*/
            finish()
        }, 1000)
    }
}