package com.cpo.base_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DummyAdapter(private val layout: Int): RecyclerView.Adapter<DummyAdapter.SearchResultViewHolder>() {
    class SearchResultViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return SearchResultViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
    }



}