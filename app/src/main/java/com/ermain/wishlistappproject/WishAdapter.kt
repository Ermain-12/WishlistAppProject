package com.ermain.wishlistappproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishAdapter(private val wishlist: MutableList<Wish>)
    : RecyclerView.Adapter<WishAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var wishItemName: TextView
        var wishItemAmount: TextView
        var wishItemURL: TextView

        init {
            wishItemName = view.findViewById(R.id.editTextWishName)
            wishItemURL = view.findViewById(R.id.textViewURL)
            wishItemAmount = view.findViewById(R.id.textViewAmount)
        }
    }

    fun addWish(wish: Wish): Unit {
        wishlist.add(wish)
        notifyItemInserted(wishlist.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val wishView = inflater.inflate(R.layout.wish_item, parent, false)

        return ViewHolder(wishView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish: Wish = wishlist[position]

        holder.wishItemName.text = wish.name
        holder.wishItemAmount.text = wish.price
        holder.wishItemURL.text = wish.url
    }

    override fun getItemCount(): Int = wishlist.size
}