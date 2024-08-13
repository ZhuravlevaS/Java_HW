// Вывести не заблокированных юзеров не из China с положительным балансом, используя метод aggregate()

db.getCollection("users").aggregate([
    {
        $match: {
            country: { $ne: "China" },
            is_blocked: { $ne: true },
            balance: { $gt: 0 }
        }
    }
])

// Вывести имена и баланс трех случайных не заблокированных юзеров из USA и France в порядке убывания баланса, используя метод aggregate()

db.getCollection("users").aggregate([
    {
        $match: {
            country: { $in: ["USA", "France"] },
            is_blocked: { $ne: true },
        },
    },
    {
        $sample: {
            size: 3
        }
    },
    {
        $sort: {
            balance: -1
        }
    },
    {
        $project: {
            _id: 0,
            fullname: 1,
            balance: 1
        }
    }
])
// Разблокировать всех юзеров с положительным балансом
db.getCollection("users").updateMany(
    {
        balance: { $gt: 0 }
    },
    {
        $set: { is_blocked: false }
    }
)
