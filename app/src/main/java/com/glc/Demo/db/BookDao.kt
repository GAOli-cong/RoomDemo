package com.glc.Demo.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.glc.Demo.bean.Book

/**
 *author:gaolc
 *date: On 2021/5/13
 *desc:
 */
@Dao
interface BookDao {
    /**
     * 添加
     */
    @Insert
    fun insertBook(book: Book):Long

    /**
     * 根据id修改名称
     */
    @Query("UPDATE tb_book SET name=:name WHERE id=:id")
    fun updateBookPrice(name:String,id:Long)

    /**
     * 查询所有
     */
    @Query("SELECT * FROM tb_book")
    fun loadAllBook():LiveData<List<Book>>


    /**
     * 根据id删除book
     */
    @Query("DELETE FROM tb_book WHERE id=:id")
    fun deleteBookById(id:Long):Int
}