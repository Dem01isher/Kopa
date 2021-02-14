package com.example.kopashop.model

data class BlogPost(

    var title: String,

    var material: String,

    var image: String,

    var username: String // Author of blog post


) {

    override fun toString(): String {
        return "BlogPost(title='$title', image='$image', username='$username')"
    }


}