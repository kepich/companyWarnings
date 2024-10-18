package ru.soft.companywarnings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ru.soft.companywarnings.model.CompanyWarning

class WarningsListAdapter(private val context: Context,
                          private val items: List<CompanyWarning>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): CompanyWarning = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val currentItem = getItem(position)
        val pictureTextView: TextView = view.findViewById(R.id.warningsListElementPicture)
        val titleTextView: TextView = view.findViewById(R.id.warningsListElementTitle)
        val priorityTextView: TextView = view.findViewById(R.id.warningsListElementPriority)
        pictureTextView.text = currentItem.picture
        titleTextView.text = currentItem.title
        priorityTextView.text = currentItem.priority.name
        return view
    }
}