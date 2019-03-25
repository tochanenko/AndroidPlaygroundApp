package com.tochanenko.kotlinplayground

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MainMenuAdapter(
    context: Context,
    private val dataSource: Array<MainMenuClass?>
) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): MainMenuClass? {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowItem = inflater.inflate(R.layout.main_menu_list_item, parent, false)

        val title = rowItem.findViewById(R.id.mainMenuTitle) as TextView
        val description = rowItem.findViewById(R.id.mainMenuDescription) as TextView

        val item = getItem(position) as MainMenuClass

        title.text = item.title
        description.text = item.description

        return rowItem
    }



}