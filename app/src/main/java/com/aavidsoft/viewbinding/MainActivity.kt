package com.aavidsoft.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.aavidsoft.viewbinding.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var product = Product("Demo Product Title", R.mipmap.ic_launcher, 12345.56F)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSetName.setOnClickListener {
            binding.txtName.text = binding.edtName.text.toString()
            //setProductToViews()
            binding.product = product
        }

    }

    private fun setProductToViews() {
        binding.txtProductTitle.text = product.title
        binding.imgProduct.setImageResource(product.imageId)
        binding.edtProductPrice.setText("${product.price}")
    }
}

@BindingAdapter("birthYear")
fun setAge(view : TextView, value : String) {
    var currentYear = Date(System.currentTimeMillis()).year
    view.setText("${currentYear - value.toInt()}")
    Log.e("tag", "Binding Adapter called")
}