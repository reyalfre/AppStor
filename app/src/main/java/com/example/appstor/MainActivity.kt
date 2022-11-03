package com.example.appstor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appstor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), StoreOnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: StoreAdapter
    private lateinit var mGridLayout: GridLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        binding.button.setOnClickListener{
            val store =Store(name = binding.editName.text.toString().trim())
            mAdapter.add(store)
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        mAdapter= StoreAdapter(mutableListOf(),this)
        mGridLayout=GridLayoutManager(this,2)

        binding.recycler.apply{
            setHasFixedSize(true)
            layoutManager=mGridLayout
            adapter=mAdapter
        }
    }
    override fun onClick(store: Store) {
        TODO("Not yet implemented")
    }
}