package com.yalantis.coreui.flow.search

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yalantis.core.models.Hero
import com.yalantis.coreui.R
import com.yalantis.coreui.base.BindingViewHolder
import com.yalantis.coreui.databinding.*

class SearchAdapter(private val viewModel: SearchHeroViewModel,
                    private val list: List<Hero>) : RecyclerView.Adapter<SearchAdapter.RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemHeroBinding>(inflater, R.layout.list_item_hero, parent, false)

        return RepoViewHolder(binding)
    }

    override fun getItemCount(): Int =
            list.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(list[position], viewModel)
    }

    class RepoViewHolder(private val binding: ListItemHeroBinding) : BindingViewHolder<Hero, SearchHeroViewModel>(binding.root) {

        override fun bind(item: Hero, viewModel: SearchHeroViewModel) {
            binding.viewModel = item
            binding.executePendingBindings()
        }
    }

}