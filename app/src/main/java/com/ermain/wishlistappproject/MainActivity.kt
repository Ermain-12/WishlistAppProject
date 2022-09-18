package com.ermain.wishlistappproject

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var wishListAdapter: WishAdapter
    private lateinit var wishName: EditText
    private lateinit var wishURL: EditText
    private lateinit var wishAmount: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wishListAdapter = WishAdapter(mutableListOf())

        // Fetch the recycler view
        val wishListRecyclerView = findViewById<RecyclerView>(R.id.wishListRV)
        wishListRecyclerView.adapter = wishListAdapter
        wishListRecyclerView.layoutManager = LinearLayoutManager(this)

        // Submit button
        val buttonAdd = findViewById<Button>(R.id.buttonSubmit)
        wishName = findViewById(R.id.editTextWishName)
        wishURL = findViewById(R.id.editTextWishURL)
        wishAmount = findViewById(R.id.editTextWishAmount)

        buttonAdd.setOnClickListener {
            val name = wishName.text.toString()
            val url = wishURL.text.toString()
            val amount = wishAmount.text.toString()
            val wishAdd = Wish(name, amount, url)
            wishListAdapter.addWish(wishAdd)
            wishName.text.clear()
            wishURL.text.clear()
            wishAmount.text.clear()
        }
    }
}