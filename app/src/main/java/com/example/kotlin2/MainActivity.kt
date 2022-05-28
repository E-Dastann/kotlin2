package com.example.kotlin2

import android.net.Uri
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kotlin2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var list: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        add()
        generalTopic()
        getInformation()

    }

    private fun getInformation() {

        binding.btnSend.setOnClickListener {
            val link = Uri.parse(binding.etView.text.toString())
            if (URLUtil.isValidUrl(link.toString())) {
                Toast.makeText(this, getString(R.string.write_here), Toast.LENGTH_SHORT).show()
                val name = binding.image
                Glide.with(this).load(link).into(name)
            } else {
                val name = binding.image
                Glide.with(this).load(link).into(name)

            }
        }
    }

    private fun generalTopic() {

        binding.randomBtn.setOnClickListener {
            val random = (0 until list.size - 1).random()

            Glide.with(this)
                .load(Uri.parse(list[random]))
                .into(binding.image)
        }
    }

    private fun add() {
        list.add("https://helpx.adobe.com/content/dam/help/en/photoshop/using/convert-color-image-black-white/jcr_content/main-pars/before_and_after/image-before/Landscape-Color.jpg")
        list.add("https://helpx.adobe.com/content/dam/help/en/photoshop/using/convert-color-image-black-white/jcr_content/main-pars/before_and_after/image-before/Landscape-Color.jpg")
        list.add("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg")
        list.add("https://images.unsplash.com/photo-1566275529824-cca6d008f3da?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8cGhvdG98ZW58MHx8MHx8&w=1000&q=80")
        list.add("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg")
        list.add("https://user-images.githubusercontent.com/3354115/58528588-ac630d80-8209-11e9-82de-0237a0978595.png")
        list.add("https://user-images.githubusercontent.com/3354115/58528588-ac630d80-8209-11e9-82de-0237a0978595.png")
        list.add("https://miro.medium.com/max/1400/1*SOlqScKss8rc9tgeZeY7Mg.png")
        list.add("https://miro.medium.com/max/1400/1*SOlqScKss8rc9tgeZeY7Mg.png")
        list.add("https://html5css.ru/css/img_lights.jpg")

    }
}