package com.example.androidepoxy.data.mapper

import com.example.androidepoxy.data.model.MenuResponse
import com.example.androidepoxy.data.model.ProductCategory
import com.example.androidepoxy.domain.model.MenuVo
import com.example.androidepoxy.domain.model.ProductCategoryVo

internal fun MenuResponse.toDomain(): MenuVo {
    return MenuVo(
        this.menus?.map { it.toDomain() }
    )
}


internal fun ProductCategory.toDomain(): ProductCategoryVo {
    return ProductCategoryVo(
        this.displayOrder,
        this.name,
        this.id,
        this.children?.map { it.toDomain() },
        this.products
    )
}