package com.example.kopashop.data.source.remote

import com.example.kopashop.domain.models.BootsModel
import com.example.kopashop.domain.response.BootsResponse
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Retrofit

class FirebaseDataSourceImpl(retrofit: Retrofit) : FirebaseDataSource {
    private val db = Firebase.firestore

    override fun getBoots(): Single<List<BootsResponse>> = Single.create {
        db.collection("shoes")
            .get()
            .addOnSuccessListener { result ->
                val list: MutableList<BootsResponse> = mutableListOf()
                for (document in result) {

                    list.add(
                        BootsResponse(
                            id = document.id,
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

    override fun getBootsById(id: String): Single<BootsResponse> = Single.create {
        db.collection("shoes")
            .document(id)
            .get()
            .addOnSuccessListener { result ->
                val boots = BootsResponse(
                            id = result.id,
                            imageUrl = result["image"].toString(),
                            title = result["title"].toString(),
                            width = result["width"].toString().toInt(),
                            price = result["price"].toString().toInt(),
                            bootsLength = result["bootsLength"].toString().toInt(),
                            material = result["material"].toString(),
                            description = result["description"].toString()
                        )
                it.onSuccess(boots)
            }
            .addOnFailureListener { exception ->
                it.onError(exception)
            }
    }

    override fun createBoots(boots: BootsModel): Completable = Completable.create {
        db.collection("shoes")
            .add(boots)
            .addOnSuccessListener { result ->
                it.onComplete()
            }
            .addOnFailureListener { exception ->
                it.onError(exception)

            }
    }

}