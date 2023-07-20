package com.barreto.mvvmexemple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.barreto.mvvmexemple.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewlModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewlModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewlModel.login().observe(this, Observer {
                Toast.makeText(applicationContext,it, Toast.LENGTH_LONG).show()
        })

        binding.buttonEntrar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val pass = binding.editPassword.text.toString()

            viewlModel.doLogin(email,pass)
        }
    }
}