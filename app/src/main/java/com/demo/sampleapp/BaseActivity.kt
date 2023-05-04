package com.demo.sampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.demo.sampleapp.databinding.ActivityBaseBinding
import timber.log.Timber

class BaseActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    internal var binding: ActivityBaseBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_base)
        setContentView(binding?.root)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}