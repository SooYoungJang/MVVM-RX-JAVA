package com.example.androidepoxy.presentation.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.example.androidepoxy.domain.model.MovieItemVo

class ProductListController : TypedEpoxyController<List<MovieItemVo>>() {

    override fun buildModels(data: List<MovieItemVo>) {
        data?.forEachIndexed { index, movieItem ->
            productListModelItemView {
                id(movieItem.subtitle)
                thumbnailUri(movieItem.image)
                albumName(movieItem.title)
                imageCount(movieItem.actor)

            }
        }
    }
/*interface AdapterCallbacksListener {
        fun onClickAlbum(album: AlbumListItem)
    }*/
}