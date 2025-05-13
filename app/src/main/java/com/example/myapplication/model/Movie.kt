package com.example.myapplication.model

class Movie (
    var id: Int,
    var name: String,
    var year: Int,
    var description: String,
    var shortDescription: String,
    var rating: Rating,
    var ageRating: Int,
    var movieLength: Int,
    var posterURL: String,
    var genres: List<String>,
    var countries: List<String>,
    var persons: List<Person>
)

