package com.cpo.base_project.activities

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.activity.ComponentActivity
import com.cpo.base_project.R
import com.cpo.base_project.databinding.ActivityCompletedBinding

class CompletedActivity:ComponentActivity() {

    private val binding by lazy { ActivityCompletedBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            animate()

            button.setOnClickListener {
                finish()
            }
        }

    }


    private fun animate(){

        //Animate layout
       binding.parent.animation = AnimationUtils.loadAnimation(
            this, R.anim.slide_up)

        //Animate amount text
        val animator = ValueAnimator.ofInt(1224, 1460)
        animator.duration = 2000
        animator.addUpdateListener { animation ->
            val animatedValue = animation.animatedValue as Int
            binding.text1.text = "$$animatedValue USD"
        }
        animator.start()
    }

}