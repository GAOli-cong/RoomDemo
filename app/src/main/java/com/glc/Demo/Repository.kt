package com.glc.Demo

import androidx.lifecycle.LiveData
import com.glc.Demo.bean.Book
import com.glc.Demo.db.AppDatabase
import com.glc.Demo.db.BookDao

/**
 *author:gaolc
 *date: On 2021/5/13
 *desc:
 */
object Repository {

    val bookDao:BookDao=AppDatabase.getDatabase(MyApp.context).bookDao()

    //查询所有
    fun loadAllBook():LiveData<List<Book>>{
        return bookDao.loadAllBook()
    }

    //修改图书价格
    fun updateBookPrice(name:String,id:Long){
        bookDao.updateBookPrice(name,id)
    }

    //添加图书
    fun insertBook(book: Book):Long{
        return bookDao.insertBook(book)
    }

    //根据id删除
    fun deleteBookById(id:Long):Int{
        return bookDao.deleteBookById(id)
    }

}