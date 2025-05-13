package com.example.myapplication.data

import com.example.myapplication.model.Movie
import com.example.myapplication.model.Person
import com.example.myapplication.model.Rating

object MoviesData {
     val movies = listOf(
        Movie(
            id = 1,
            name = "1+1",
            year = 2011,
            description = "Пострадав в результате несчастного случая, богатый аристократ Филипп нанимает в помощники человека, который менее всего подходит для этой работы, – молодого жителя предместья Дрисса, только что освободившегося из тюрьмы. Несмотря на то, что Филипп прикован к инвалидному креслу, Дриссу удается привнести в размеренную жизнь аристократа дух приключений.",
            shortDescription = "Аристократ на коляске нанимает в сиделки бывшего заключенного. Искрометная французская комедия с Омаром Си",
            rating = Rating(kp = 8.9, imdb = 8.5),
            movieLength = 112,
            ageRating = 18,
            posterURL = "https://image.openmoviedb.com/kinopoisk-images/10900341/caf9f155-1a19-42f1-a0f3-9c8773e9083e/orig",
            genres = listOf("драма", "комедия"),
            countries = listOf("Франция"),
            persons = listOf(
                Person(
                    photoURL = "https://image.openmoviedb.com/kinopoisk-st-images//actor_iphone/iphone360_71427.jpg",
                    name = "Франсуа Клюзе",
                    character = "Philippe",
                ),
                Person(
                    photoURL = "https://image.openmoviedb.com/kinopoisk-st-images//actor_iphone/iphone360_41644.jpg",
                    name = "Омар Си",
                    character = "Driss",
                ),
                Person(
                    photoURL = "https://image.openmoviedb.com/kinopoisk-st-images//actor_iphone/iphone360_57174.jpg",
                    name = "Анн Ле Ни",
                    character = "Yvonne",
                ),
            )
        ),
        Movie(
            id = 2,
            name = "Интерстеллар",
            year = 2014,
            description = "Когда засуха, пыльные бури и вымирание растений приводят человечество к продовольственному кризису, коллектив исследователей и учёных отправляется сквозь червоточину (которая предположительно соединяет области пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических путешествий человека и найти планету с подходящими для человечества условиями.",
            shortDescription = "Фантастический эпос про задыхающуюся Землю, космические полеты и парадоксы времени. «Оскар» за спецэффекты",
            rating = Rating(kp = 8.7, imdb = 8.7),
            movieLength = 169,
            ageRating = 18,
            posterURL = "https://image.openmoviedb.com/kinopoisk-images/1600647/430042eb-ee69-4818-aed0-a312400a26bf/orig",
            genres = listOf("фантастика", "драма", "приключения"),
            countries = listOf("США", "Великобритания", "Канада"),
            persons = listOf(
                Person(
                    photoURL = "https://image.openmoviedb.com/kinopoisk-st-images//actor_iphone/iphone360_797.jpg",
                    name = "Мэттью Макконахи",
                    character = "Cooper",
                ),
                Person(
                    photoURL = "https://image.openmoviedb.com/kinopoisk-st-images//actor_iphone/iphone360_38703.jpg",
                    name = "Энн Хэтэуэй",
                    character = "Brand",
                ),
                Person(
                    photoURL = "https://image.openmoviedb.com/kinopoisk-st-images//actor_iphone/iphone360_1111242.jpg",
                    name = "Джессика Честейн",
                    character = "Murph",
                )
            )
        ),
        Movie(
            id = 3,
            name = "Побег из Шоушенка",
            year = 1994,
            description = "Бухгалтер Энди Дюфрейн обвинён в убийстве собственной жены и её любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решётки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, обладающий живым умом и доброй душой, находит подход как к заключённым, так и к охранникам, добиваясь их особого к себе расположения.",
            shortDescription = "Несправедливо осужденный банкир готовит побег из тюрьмы. Тим Роббинс в выдающейся экранизации Стивена Кинга",
            rating = Rating(kp = 9.1, imdb = 9.3),
            movieLength = 142,
            ageRating = 18,
            posterURL = "https://image.openmoviedb.com/kinopoisk-images/1599028/0b76b2a2-d1c7-4f04-a284-80ff7bb709a4/orig",
            genres = listOf("драма"),
            countries = listOf("США"),
            persons = listOf(
                Person(
                    photoURL = "https://image.openmoviedb.com/kinopoisk-st-images//actor_iphone/iphone360_7987.jpg",
                    name = "Тим Роббинс",
                    character = "Andy Dufresne",
                ),
                Person(
                    photoURL = "https://image.openmoviedb.com/kinopoisk-st-images//actor_iphone/iphone360_6750.jpg",
                    name = "Морган Фриман",
                    character = "Ellis Boyd 'Red' Redding",
                ),
                Person(
                    photoURL = "https://image.openmoviedb.com/kinopoisk-st-images//actor_iphone/iphone360_23481.jpg",
                    name = "Боб Гантон",
                    character = "Warden Norton",
                )
            )
        )
    )
}