package com.example.lab1

class TransportRepository {
    fun getTransportList(): List<TransportItem> {
        return listOf(
            PopularBrandsItem(
                id = "brands_row",
                brands = listOf("BMW", "Audi", "Toyota", "Porsche", "Koenigsegg", "Ferrari", "Lamborghini", "Bugatti", "McLaren", "Aston Martin", "Pagani", "Mercedes", "Nissan")
            ),
            CarItem(id = "c1", brand = "BMW", model = "M3", color = "Blue", year = 2022),
            CarItem(id = "c2", brand = "Toyota", model = "Camry", color = "Black", year = 2020),
            MotorcycleItem(id = "m1", brand = "Yamaha", engineVolume = 600, type = "Sportbike"),
            CarItem(id = "c3", brand = "Audi", model = "RS6", color = "Gray", year = 2023),
            CarItem(id = "c4", brand = "Porsche", model = "911 GT3 RS", color = "Lizard Green", year = 2024),
            CarItem(id = "c5", brand = "Koenigsegg", model = "Jesko Absolut", color = "White & Carbon", year = 2023),
            CarItem(id = "c6", brand = "Ferrari", model = "SF90 Stradale", color = "Rosso Corsa Red", year = 2023),
            CarItem(id = "c7", brand = "Lamborghini", model = "Revuelto", color = "Arancio Orange", year = 2024),
            MotorcycleItem(id = "m2", brand = "Harley-Davidson", engineVolume = 1200, type = "Cruiser"),
            CarItem(id = "c8", brand = "Bugatti", model = "Chiron Super Sport", color = "Blue / Black", year = 2022),
            MotorcycleItem(id = "m3", brand = "Ducati", engineVolume = 1103, type = "Panigale V4"),
            CarItem(id = "c9", brand = "McLaren", model = "750S", color = "Volcano Yellow", year = 2024),
            CarItem(id = "c10", brand = "Aston Martin", model = "Valkyrie", color = "British Racing Green", year = 2023),
            CarItem(id = "c11", brand = "Pagani", model = "Huayra Roadster", color = "Blue Carbon", year = 2022),
            CarItem(id = "c12", brand = "Mercedes-AMG", model = "GT Black Series", color = "Magma Beam Orange", year = 2023),
            CarItem(id = "c13", brand = "Nissan", model = "GT-R Nismo", color = "Bayside Blue", year = 2024)
        )
    }
}