package com.example.appstor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appstor.databinding.ItemShopBinding

class StoreAdapter(private var  stores: MutableList<Store>,
                    private var listener: StoreOnClickListener):RecyclerView.Adapter<StoreAdapter.ViewHolder>() {
   inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val binding= ItemShopBinding.bind(view)
        fun bind(store: Store){
            binding.textName.text=store.name
        }
        fun setListener(store: Store){
            binding.root.setOnClickListener{listener.onClick(store)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shop, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store=stores.get(position)
        holder.bind(store)
        holder.setListener(store)
    }

    override fun getItemCount(): Int {
        return stores.size
    }
    fun add(store: Store){
        stores.add(store)
        notifyDataSetChanged()
    }
}


