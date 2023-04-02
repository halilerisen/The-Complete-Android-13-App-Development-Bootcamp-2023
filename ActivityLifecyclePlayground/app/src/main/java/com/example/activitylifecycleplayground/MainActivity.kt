package com.example.activitylifecycleplayground

import android.os.Bundle
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.activitylifecycleplayground.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val testFragment: TestFragment = TestFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFinish.setOnClickListener { showDialog() }
        binding.buttonSave.setOnClickListener { saveMessage() }
        binding.buttonShowFragment.setOnClickListener { showFragment() }
        binding.buttonRemoveFragment.setOnClickListener { removeFragment() }

        onBackPressedDispatcher.addCallback(this) { showDialog() }

        binding.textViewSavedMessage.text = savedInstanceState?.getString("savedMessage")

    }

    private fun removeFragment() {
        supportFragmentManager.commit {
            remove(testFragment)
        }
    }

    private fun showFragment() {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, testFragment)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val savedTextMessage = binding.textViewSavedMessage.text.toString()
        outState.putString("savedMessage", savedTextMessage)
    }

    private fun saveMessage() {
        val userMessage = binding.editTextMessage.text
        File(filesDir, "user message.txt").writeText(userMessage.toString())
        binding.textViewSavedMessage.text = "Your message has been saved!\n\nMessage Preview:\n\n$userMessage"
        binding.editTextMessage.setText("")

    }

    private fun showDialog() {
        AlertDialog.Builder(this)
            .setTitle("Waning!")
//            .setMessage("You are about to leave the app. Are you sure you want to exit?")
            .setView(R.layout.dialog_warning)
            .setPositiveButton("Yes") { _, _ ->
                finish()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.cancel()
            }
            .setNeutralButton("More Info") { _, _ ->
                Toast.makeText(this, "More info", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

}