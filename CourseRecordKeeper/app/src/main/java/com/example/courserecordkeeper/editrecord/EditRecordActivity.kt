package com.example.courserecordkeeper.editrecord

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.courserecordkeeper.databinding.ActivityEditRecordBinding
import java.io.Serializable

class EditRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRecordBinding
    private val screenData by lazy { intent.getSerializableExtra("screen_data") as ScreenData }
    private val recordPreferences by lazy { getSharedPreferences(screenData.sharedPreferencesName, Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUi()

        displayRecord()
    }

    private fun setupUi() {
        title = "${screenData.record} ${screenData.recordFieldHint}"
        binding.textInputRecord.hint = screenData.recordFieldHint

        binding.buttonSave.setOnClickListener {
            saveRecord()
            finish()
        }
        binding.buttonDelete.setOnClickListener {
            clearRecord()
            finish()
        }
    }

    private fun displayRecord() {
        val runningPreferences = getSharedPreferences(screenData.sharedPreferencesName, Context.MODE_PRIVATE)
        binding.editTextRecord.setText(runningPreferences.getString("${screenData.record} ${screenData.recordFieldHint}", null))
        binding.editTextDate.setText(runningPreferences.getString("${screenData.record} date", null))

    }

    private fun saveRecord() {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()

        recordPreferences.edit {
            putString("${screenData.record} ${screenData.recordFieldHint}", record)
            putString("${screenData.record} date", date)
        }
    }

    private fun clearRecord() {
        recordPreferences.edit {
            remove("${screenData.record} ${screenData.recordFieldHint}")
            remove("${screenData.record} date")
        }
    }

    data class ScreenData(
        val record: String,
        val sharedPreferencesName: String,
        val recordFieldHint: String,
    ) : Serializable
}