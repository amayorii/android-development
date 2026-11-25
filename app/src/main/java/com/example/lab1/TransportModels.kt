package com.example.lab1

sealed interface TransportItem {
    val id: String
}

data class CarItem(
    override val id: String,
    val brand: String,
    val model: String,
    val color: String,
    val year: Int
) : TransportItem

data class MotorcycleItem(
    override val id: String,
    val brand: String,
    val engineVolume: Int,
    val type: String
) : TransportItem

data class PopularBrandsItem(
    override val id: String,
    val brands: List<String>
) : TransportItem