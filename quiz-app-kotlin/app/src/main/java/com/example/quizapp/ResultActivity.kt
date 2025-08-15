package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Fetch data from Intent
        val userName = intent.getStringExtra(Constants.USER_NAME) ?: "User"
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val score = intent.getIntExtra(Constants.SCORE, 0)

        // Find views
        val congratulationsTv: TextView = findViewById(R.id.congratulationsTv)
        val scoreTv: TextView = findViewById(R.id.scoreTv)
        val btnRestart: Button = findViewById(R.id.btnRestart)

        // Set texts
        congratulationsTv.text = "Congratulations, $userName!"
        scoreTv.text = "Your score is $score out of $totalQuestions"

        // Restart button action
        btnRestart.setOnClickListener {
            val restartIntent = Intent(this, MainActivity::class.java)
            startActivity(restartIntent)
            finish()
        }
    }
}