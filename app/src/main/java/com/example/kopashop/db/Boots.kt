package com.example.kopashop.db

class Boots {

    lateinit var bootsTitle: String
    lateinit var size: String
    lateinit var image: String
    lateinit var price: String
    lateinit var material: String

    constructor(bootsTitle: String, size: String, image: String, price: String, material: String){
        this.bootsTitle = bootsTitle
        this.size = size
        this.image = image
        this.price = price
        this.material = material
    }

}