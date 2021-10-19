package com.example.androidepoxy.presentation.epoxy

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.androidepoxy.R
import com.example.androidepoxy.presentation.model.ProductParams

@EpoxyModelClass(layout = R.layout.item_products)
abstract class homeFragmentModel : EpoxyModelWithHolder<AlbumListItemViewHolder>() {

    @EpoxyAttribute
    lateinit var itemData: ProductParams

    override fun bind(holder: Holder) {
        holder.textView.text = itemText
        holder.button.setOnclickListener { listener() }
    }

    override fun unbind(holder: AlbumListItemViewHolder) {
        super.unbind(holder)
    }



    class Holder : EpoxyHolder() {
        lateinit var binding:
            private set
        override fun bindView(itemView: View) {
            textView = itemView.findViewById(R.id.tv_text)
            button = itemView.findViewById(R.id.btn)
        }
    }
}