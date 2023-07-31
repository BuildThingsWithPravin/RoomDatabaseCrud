package com.example.demohilt

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demohilt.data.NetworkClass
import com.example.demohilt.data.PassengerModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: PassengerListAdapter
    private lateinit var recyclerList: RecyclerView
    private var isLoading = false
    private val PAGE_SIZE = 10
    private val itemList = mutableListOf<PassengerModel.Data?>()
    private var page = 1

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerList = findViewById(R.id.recycler_list)

//        viewModel.getUser("sure@yopmail.com", "123456789", true)

        viewModel.getPassengerList(page, 15)
        adapter = PassengerListAdapter(::addItemsToList)
        recyclerList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                // Check if the user has scrolled to the bottom and load more items
                if (!isLoading && (visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    && firstVisibleItemPosition >= 0 && totalItemCount >= PAGE_SIZE
                ) {
                    page += 1
                    viewModel.getPassengerList(page, 15)
                } else {
                    isLoading = true
                }
            }
        })

        recyclerList.layoutManager = LinearLayoutManager(this)
        recyclerList.adapter = adapter


        viewModel.passengerResponse.observe(this) {
            when (it) {
                is NetworkClass.Error -> isLoading = true
                is NetworkClass.Success -> {
                    isLoading = true
                    itemList.addAll(it.data!!.data)
                    adapter.submitList(itemList)
                    adapter.notifyDataSetChanged()

                }

                is NetworkClass.Loading -> isLoading = true
            }
        }

//        viewModel.getUsers("2545124580")

        viewModel.userDatas.observe(this) {
            when (it) {
                is NetworkClass.Error -> Log.e("TAG", "2545124580 Error: ${it.message}")
                is NetworkClass.Success -> Log.e("TAG", "2545124580 Success: ${it.message}")
                is NetworkClass.Loading -> Log.e("TAG", "2545124580 Loading: ${it.message}")
            }
        }

    }

    private fun addItemsToList() {
        isLoading = true

        itemList.add(itemList.size - 1, null) // Use a special item ID (-1) for the loader
        adapter.notifyItemInserted(itemList.size - 1)
    }

}