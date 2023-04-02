package com.example.buildformchallange

import android.R.layout.simple_spinner_dropdown_item
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.buildformchallange.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpSpinner()
        setUpButton()
    }

    private fun setUpButton() {
        val titles = arrayOf(
            "Miss", "Mrs", "Ms", "Mr", "Mx", "Dr", "Prof"
        )

        val titleAdapter = ArrayAdapter<String>(this, simple_spinner_dropdown_item, titles)
        binding.spinnerTitle.adapter = titleAdapter
    }

    private fun setUpSpinner() {
        binding.buttonCreateAccount.setOnClickListener {
            createAccount()
        }
    }

    private fun createAccount() {
        val user = User(
            binding.spinnerTitle.selectedItem as String,
            binding.editTextFirstName.text.toString(),
            binding.editTextLastName.text.toString(),
            binding.editTextEmail.text.toString(),
            binding.editTextPhoneNumber.text.toString(),
            binding.editTextPassword.text.toString(),
        )

        val summaryActivityIntent = Intent(this, SummaryActivity::class.java)
        summaryActivityIntent.putExtra("user_information", user)

        startActivity(summaryActivityIntent)

    }
}