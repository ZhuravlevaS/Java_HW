// Вывести данные об одном треке (на ваш выбор)

db.getCollection("tracks").findOne({
    _id: ObjectId("6683d12611f71ad854072f90")
})

// Вывести данные юзеров не из USA (в проекции - без страны)

db.getCollection("users").find({
    country: {
        $ne: "USA"
    }
}, {
    country: 0
})

// Вывести данные о треках продолжительностью 30 мин и более (в проекции - без первичного ключа)

db.getCollection("tracks").find({
        duration_sec: {
            $gte: 60 * 30
        },
    },
    {
        _id: 0
    })

// Вывести страны и имена всех клиентов (решение данной задачи оформить в виде PR)

db.getCollection("users").find(
    {},
    {
        country: 1, fullname: 1, _id: 0
    })
