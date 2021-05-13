package com.glc.Demo.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *author:gaolc
 *date: On 2021/5/13
 *desc:
 */
@Entity(tableName = "tb_book")
 class Book(var name:String,var price:Int) {
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}