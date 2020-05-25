package com.audiodrogon.new_quiz_app.models

class Question(
    var id: Int,
    var questiontext: String?,
    var questionimage: String?,
    var answerA : String?,
    var answerB : String?,
    var answerC : String?,
    var answerD : String?,
    var correctAnswer : String?,
    var isImageQuestion: Boolean,
    var categoryId : Int
)