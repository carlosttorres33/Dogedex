package com.carlostorres.dogedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.carlostorres.dogedex.data.models.DogListResponse
import com.carlostorres.dogedex.databinding.ActivityDogDetailBinding

class DogDetailActivity : AppCompatActivity() {

    companion object{
        const val DOG_KEY = "dog"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDogDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val dog = intent?.extras?.getParcelable<DogListResponse>(DOG_KEY)

        if (dog == null){
            Toast.makeText(this, "DOG NOT FOUND", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        binding.dogIndex.text = getString(R.string.dog_index_format, dog.index)
        binding.lifeExpectancy.text = getString(R.string.dog_life, dog.life_expectancy)
        binding.dog = dog
    }
}