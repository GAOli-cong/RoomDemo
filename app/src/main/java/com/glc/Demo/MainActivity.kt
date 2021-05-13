package com.glc.Demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.glc.Demo.adapter.BookAdapter
import com.glc.Demo.bean.Book
import com.glc.Demo.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val list=ArrayList<Book>()
    private lateinit var adapter: BookAdapter
    private val mainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //初始化适配器
        adapter=BookAdapter(R.layout.item_book,list)
        binding.rvBook.adapter=adapter


        //viewModel+liveData监听数据变化---数据变化 列表刷新
        mainViewModel.getAll().observe(this, Observer {
            list.clear()
            Log.d(TAG, "onCreate: ${it.size}")
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })
        //注册点击事件
        adapter.addChildClickViewIds(R.id.btnDelete,R.id.btnUpdate)

        //item子控件点击事件
        adapter.setOnItemChildClickListener(object :OnItemChildClickListener{
            override fun onItemChildClick(
                adapter: BaseQuickAdapter<*, *>,
                view: View,
                position: Int
            ) {
                if(view.id==R.id.btnDelete){//删除按钮
                    thread {
                        Repository.deleteBookById(list[position].id)
                    }
                }else if(view.id==R.id.btnUpdate){//修改按钮
                    thread {
                        Repository.updateBookPrice("我被修改了！！",list[position].id)
                    }
                }

            }
        })





        //添加
        binding.btnAdd.setOnClickListener {
            val name = binding.edtBook.text.toString().trim()
            val price = binding.edtPrice.text.toString()
            if(name==""||price==""){
                Toast.makeText(this, "请填写完整", Toast.LENGTH_SHORT).show()
            }else{
                val book=Book(name,price.toInt())
                thread {
                    val id=Repository.insertBook(book)
                    Log.d(TAG, "onCreate: ${id}")
                }
            }

        }





    }

    companion object {
        private const val TAG = "MainActivity"
    }
}