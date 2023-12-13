package com.example.lab3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.ToggleButton
import kotlin.reflect.KVisibility

class NewActivity : AppCompatActivity() {
    private var up:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val heightText = findViewById<EditText>(R.id.height)
        val speedText = findViewById<EditText>(R.id.speed)
        val timeText = findViewById<EditText>(R.id.time)
        val isDownFlag = findViewById<ToggleButton>(R.id.downButton)

        val calculateButton = findViewById<Button>(R.id.calculate_button)
        var resultText = findViewById<TextView>(R.id.result_textview)

        isDownFlag.setOnClickListener{
            up=!up
        }

        calculateButton.setOnClickListener {
            val point = Point(
                up,
                heightText.text.toString().toInt(),
                speedText.text.toString().toInt(),
                timeText.text.toString().toInt()
            )

            var pointAltitude = point.getAltitude();

            resultText.text = pointAltitude.toString();
            resultText.visibility = View.VISIBLE;

            val answer = Intent().putExtra("altitude", pointAltitude)
            setResult(Activity.RESULT_OK, answer)
        };
    }
}