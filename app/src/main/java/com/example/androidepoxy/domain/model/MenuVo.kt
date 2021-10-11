package com.example.androidepoxy.domain.model

import com.example.androidepoxy.data.model.ProductItem

data class MenuVo(
    val menus: List<ProductCategoryVo>? = null
)


data class ProductCategoryVo(
    val displayOrder: Int? = null,
    val name: String? = null,
    val id: String? = null,
    val children: List<ProductCategoryVo>? = null,
    val products: List<ProductItem>? = null
)


data class ProductItemVo(
    val name: String? = null,
    val formCode: String? = null,
    val displayOrder: Int? = null,
    val productNumber: Long? = null,
    val productType: String? = null,
    val availability: String? = null,
    val assets: ProductAssets? = null,
    val sizes: List<ProductSize>? = null,
    val uri: String? = null,
) {

    val imageUrlOrNull: String?
        get() {
            return assets?.thumbnail?.large?.uri ?: assets?.fullSize?.uri
            ?: assets?.masterImage?.uri
        }
}

data class ProductSize(
    val sizeCode: String? = null
)

data class ProductAssets(
    val thumbnail: ProductThumbnail? = null,
    val fullSize: ProductImageSource? = null,
    val masterImage: ProductImageSource? = null,
)

data class ProductThumbnail(
    val large: ProductImageSource? = null
)

data class ProductImageSource(
    val uri: String? = null,
)