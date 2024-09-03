package com.cpo.base_project.activities

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.window.OnBackInvokedDispatcher
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import com.cpo.base_project.R
import com.cpo.base_project.adapters.DummyAdapter
import com.cpo.base_project.databinding.ActivityHistoryBinding
import com.google.android.material.tabs.TabLayout

class HistoryActivity: ComponentActivity() {

    private val binding by lazy { ActivityHistoryBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){

            setupTabs()

            toolbar.setNavigationOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }

            DummyAdapter(R.layout.itemview_history).apply {
                historyRv.adapter = this
                historyRv.animation = AnimationUtils.loadAnimation(
                    this@HistoryActivity, R.anim.slide_up)

                tabLayout.animation = AnimationUtils.loadAnimation(
                    this@HistoryActivity, R.anim.slide_in_from_right
                )
            }

        }

    }


    private fun setupTabs(){
        val tabTitles = arrayOf(Tab("All", 15),
            Tab("Completed", 5),
            Tab("In progress", 3),
            Tab("Pending order", 4),
            Tab("Cancelled", 0))

        for (i in tabTitles.indices) {
            val tab = binding.tabLayout.newTab()
            val customView = layoutInflater.inflate(R.layout.custom_tab_item, null)

            val tabTextView = customView.findViewById<TextView>(R.id.title)
            tabTextView.text = tabTitles[i].title

            val badgeView = customView?.findViewById<TextView>(R.id.badge)
            badgeView?.visibility = if (tabTitles[i].count == 0) View.GONE else View.VISIBLE
            badgeView?.text = tabTitles[i].count.toString()

            tab.customView = customView
            binding.tabLayout.addTab(tab)
        }
    }

    data class Tab(
        val title: String,
        val count: Int
    )



    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
        finishAfterTransition()
        return super.getOnBackInvokedDispatcher()
    }


}