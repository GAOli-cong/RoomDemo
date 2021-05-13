package com.glc.Demo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.glc.Demo.bean.Book

/**
 *author:gaolc
 *date: On 2021/5/13
 *desc:
 */
@Database(version = 1,entities = [Book::class],exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun bookDao(): BookDao
    companion object{
        private var instance:AppDatabase?=null
        @Synchronized
        fun getDatabase(context: Context):AppDatabase{
            instance?.let {
                return it
            }
            return Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java,"app_db")
                .build().apply {
                    instance=this
                }
        }
    }
}