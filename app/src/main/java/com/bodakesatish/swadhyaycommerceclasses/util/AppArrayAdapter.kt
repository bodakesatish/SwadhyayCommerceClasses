package com.bodakesatish.swadhyaycommerceclasses.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.viewbinding.ViewBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.ItemLayoutBinding.*

class AppArrayAdapter<T>(
    context: Context, items: List<T>, private val bindData: (ViewBinding, T) -> Unit
) : ArrayAdapter<T>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewLayout = inflate(LayoutInflater.from(context))
        getItem(position)?.let { bindData(viewLayout, it) }
        return viewLayout.root
    }

}