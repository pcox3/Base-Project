package com.cpo.base_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.cpo.base_project.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


}
