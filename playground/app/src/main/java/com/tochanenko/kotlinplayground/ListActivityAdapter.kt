package com.tochanenko.kotlinplayground

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class ListActivityAdapter(
        private val context: Context,
        private val dataSource: Array<LinkClass?>
) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): LinkClass? {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView (position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.list_item, parent, false)

        val titleText = rowView.findViewById(R.id.listItemTitle) as TextView
        val descriptionText = rowView.findViewById(R.id.listItemDescription) as TextView
        val button = rowView.findViewById(R.id.listItemButton) as Button

        val singleLink = getItem(position) as LinkClass

        titleText.text = singleLink.title
        descriptionText.text = singleLink.description

        button.setOnClickListener {
            val uri = Uri.parse(singleLink.link)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            context.startActivity(intent)
        }



        return rowView
    }

}