package com.glc.Demo.adapter

import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.glc.Demo.R
import com.glc.Demo.bean.Book
/**
 *author:gaolc
 *date: On 2021/5/13
 *desc:
 */
class BookAdapter(layoutId:Int,list:ArrayList<Book>):BaseQuickAdapter<Book,BaseViewHolder>(layoutId,list){
    override fun convert(holder: BaseViewHolder, item: Book) {
        holder.setText(R.id.tv_name,item.name.toString())
        holder.setText(R.id.tv_price,item.price.toString())
    }

}