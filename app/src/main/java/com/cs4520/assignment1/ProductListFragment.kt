package com.cs4520.assignment1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment1.databinding.ProductListFragmentBinding

class ProductListFragment : Fragment() {
    private var _binding: ProductListFragmentBinding? = null

    private val binding get() = _binding!!

    private fun processProduct(p: List<Any?>): Product {
        if (p[1].toString() == "Equipment") {
            return Equipment(p[0].toString(), p[2].toString(), p[3].toString().toInt())
        }
        return Food(p[0].toString(), p[2].toString(), p[3].toString().toInt())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = ProductListFragmentBinding.inflate(inflater, container, false)

        val processedData = productsDataset.map{ p -> processProduct(p) }
        val customAdapter = ProductListAdapter(processedData)

        binding.productListRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.productListRecyclerView.adapter = customAdapter
        return binding.root
    }
}