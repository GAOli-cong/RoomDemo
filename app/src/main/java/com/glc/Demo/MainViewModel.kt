package com.glc.Demo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.glc.Demo.bean.Book

/**
 *author:gaolc
 *date: On 2021/5/13
 *desc:
 */
class MainViewModel :ViewModel() {

    //查询所有的book
    fun getAll():LiveData<List<Book>>{
        return Repository.loadAllBook()
    }
}