package com.example.buildformchallange

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.buildformchallange.databinding.ActivitySummaryBinding


@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrieveUser()
        displayUser()
        setupClickListener()

    }

    private fun retrieveUser() {
        user = intent.getSerializableExtra("user_information") as User
    }

    private fun displayUser() {
        binding.textViewNameSurname.text = user.getFullName()
        binding.textViewEmail.text = user.email
        binding.textViewPhoneNumber.text = user.phoneNumber

    }

    private fun setupClickListener() {
        binding.textViewEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${user.email}")
            startActivity(intent)
        }

        binding.textViewPhoneNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user.phoneNumber}")
            startActivity(intent)
        }
    }

}