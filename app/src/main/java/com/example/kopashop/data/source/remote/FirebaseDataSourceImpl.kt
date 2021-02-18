package com.example.kopashop.data.source.remote

import com.example.kopashop.domain.models.response.Boots
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import io.reactivex.Single
import retrofit2.Retrofit

class FirebaseDataSourceImpl(retrofit: Retrofit) : FirebaseDataSource {
    private val db = Firebase.firestore

    override fun getBoots(): Single<List<Boots>> = Single.create {
        db.collection("shoes")
            .get()
            .addOnSuccessListener { result ->
                val list: MutableList<Boots> = mutableListOf()
                for (document in result) {

                    list.add(
                        Boots(
                        imageUrl = document["image"].toString(),
                        title = document["title"].toString(),
                        width = document["width"].toString().toInt(),
                        price = document["price"].toString().toInt(),
                        bootsLength = document["bootsLength"].toString().toInt(),
                        material = document["material"].toString()
                        )
                    )
                }
                it.onSuccess(list)
            }
            .addOnFailureListener { exception ->
                it.onError(exception)
            }
    }
}