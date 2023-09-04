package ru.sr.testtaskhotel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = this.getColor(R.color.white)
        window.navigationBarColor = this.getColor(R.color.white)
        setContentView(R.layout.activity_main)
    }
}