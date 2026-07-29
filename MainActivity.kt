package com.taylan.whatsappalarm

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var triggerInput: EditText
    private lateinit var currentTriggerText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        triggerInput = findViewById(R.id.triggerInput)
        currentTriggerText = findViewById(R.id.currentTriggerText)

        val savedTrigger = TriggerSettings.getTrigger(this)
        triggerInput.setText(savedTrigger)
        showCurrentTrigger(savedTrigger)

        findViewById<Button>(R.id.saveTriggerButton).setOnClickListener {
            val newTrigger = triggerInput.text.toString().trim()
            if (newTrigger.isBlank()) {
                triggerInput.error = "Tetikleyici boş bırakılamaz"
                return@setOnClickListener
            }

            TriggerSettings.saveTrigger(this, newTrigger)
            showCurrentTrigger(newTrigger)
            Toast.makeText(this, "Tetikleyici kaydedildi", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.openSettingsButton).setOnClickListener {
            startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
        }

        findViewById<Button>(R.id.stopAlarmButton).setOnClickListener {
            AlarmController.stop()
        }
    }

    override fun onResume() {
        super.onResume()
        val enabled = Settings.Secure.getString(
            contentResolver,
            "enabled_notification_listeners"
        )?.contains(packageName) == true

        findViewById<TextView>(R.id.statusText).text = if (enabled) {
            "Bildirim erişimi açık. Uygulama hazır."
        } else {
            "Bildirim erişimi kapalı. Aşağıdaki düğmeden açın."
        }
    }

    private fun showCurrentTrigger(trigger: String) {
        currentTriggerText.text = "Etkin tetikleyici: $trigger"
    }
}
