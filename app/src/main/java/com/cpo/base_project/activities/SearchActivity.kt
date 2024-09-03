package com.cpo.base_project.activities

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.window.OnBackInvokedDispatcher
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.cpo.base_project.R
import com.cpo.base_project.adapters.DummyAdapter
import com.cpo.base_project.databinding.ActivitySearchBinding


class SearchActivity: ComponentActivity() {

    private val binding by lazy { ActivitySearchBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){

            searchView.requestFocus()
            DummyAdapter(R.layout.itemview_search_result).apply {
                searchRv.adapter = this
                val dividerItemDecoration =
                    DividerItemDecoration(searchRv.context,
                        LinearLayoutManager.VERTICAL)
                searchRv.addItemDecoration(dividerItemDecoration)
                searchRv.animation = AnimationUtils.loadAnimation(
                    this@SearchActivity, R.anim.slide_up)
            }

            toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        }
    }



    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
        finishAfterTransition()
        return super.getOnBackInvokedDispatcher()
    }


}