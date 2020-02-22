package rostilav.mybus.data

import rostilav.mybus.domain.*

/*Нам нужно хранить
расписание
название расписаний
название маршрута
название конечных остановок
название остановок и время от старта до остановки
*/

class DataBase {
    private  val progress= arrayOf(
       RoadPoint(MTime().parse("00:03"), "ЦУМ"),
       RoadPoint(MTime().parse("00:05"), "Детский мир"),
       RoadPoint(MTime().parse("00:12"), "12 Сентября"),
       RoadPoint(MTime().parse("00:16"), "Аквамолл"),
       RoadPoint(MTime().parse("00:18"), "Пушкаревское Кольцо"),
       RoadPoint(MTime().parse("00:22"), "УАЗ"),
       RoadPoint(MTime().parse("00:38"), "Вещевой Рынок")
    )
    private  val progressBack= arrayOf(
        RoadPoint(MTime().parse("00:17"), "Вещевой Рынок"),
        RoadPoint(MTime().parse("00:25"), "УАЗ"),
        RoadPoint(MTime().parse("00:32"), "Пушкаревское Кольцо"),
        RoadPoint(MTime().parse("00:43"), "12 Сентября"),
        RoadPoint(MTime().parse("00:55"), "Детский мир"),
        RoadPoint(MTime().parse("00:59"), "ЦУМ")
    )

  internal val testItinerary: Itinerary = Itinerary(
        title = "31",
        startPoint = "Центробанк",
        finishPoint = "Карлинское",
        timeTableArray = arrayOf(
            TimeTable(
                isTo = true,
                isWorkingDays = true,
                starDescription = "До Церкви",
                flightList = listOf(
                    Flight().parse("04:52,+"),
                    Flight().parse("05:10,+"),
                    Flight().parse("05:30,+"),
                    Flight().parse("06:00,+"),
                    Flight().parse("06:30,+"),
                    Flight().parse("06:54,+"),
                    Flight().parse("07:35,-"),
                    Flight().parse("08:00,-"),
                    Flight().parse("09:00,+"),
                    Flight().parse("11:00,+"),
                    Flight().parse("12:00,-"),
                    Flight().parse("13:00,-"),
                    Flight().parse("14:00,+"),
                    Flight().parse("14:40,+"),
                    Flight().parse("15:00,+"),
                    Flight().parse("15:30,+"),
                    Flight().parse("16:50,+"),
                    Flight().parse("16:37,+"),
                    Flight().parse("17:15,+"),
                    Flight().parse("17:40,+"),
                    Flight().parse("18:12,-"),
                    Flight().parse("19:10,+"),
                    Flight().parse("19:45,+"),
                    Flight().parse("20:30,-")
                ),
                progress = progress
            ),
            TimeTable(
                isTo = false,
                isWorkingDays = true,
                starDescription = "От Церкви",
                flightList = listOf(
                    Flight().parse("05:30,-"),
                    Flight().parse("05:45,-"),
                    Flight().parse("06:30,-"),
                    Flight().parse("07:00,-"),
                    Flight().parse("07:27,-"),
                    Flight().parse("07:54,-"),
                    Flight().parse("08:30,+"),
                    Flight().parse("09:00,+"),
                    Flight().parse("10:00,-"),
                    Flight().parse("12:00,-"),
                    Flight().parse("13:00,+"),
                    Flight().parse("14:00,+"),
                    Flight().parse("15:00,-"),
                    Flight().parse("15:40,-"),
                    Flight().parse("16:00,-"),
                    Flight().parse("16:30,-"),
                    Flight().parse("17:15,-"),
                    Flight().parse("17:37,-"),
                    Flight().parse("18:12,-"),
                    Flight().parse("18:40,-"),
                    Flight().parse("19:50,+"),
                    Flight().parse("20:10,-"),
                    Flight().parse("20:45,-"),
                    Flight().parse("21:25,+")
                ),
                progress =progressBack
            ),
            TimeTable(
                isTo = true,
                isWorkingDays = false,
                starDescription = "До Церкви",
                flightList = listOf(
                    Flight().parse("05:20,+"),
                    Flight().parse("05:55,-"),
                    Flight().parse("08:00,+"),
                    Flight().parse("09:15,-"),
                    Flight().parse("11:15,-"),
                    Flight().parse("12:00,+"),
                    Flight().parse("13:00,+"),
                    Flight().parse("13:55,-"),
                    Flight().parse("14:50,+"),
                    Flight().parse("16:00,-"),
                    Flight().parse("16:50,+"),
                    Flight().parse("18:00,+"),
                    Flight().parse("19:15,-"),
                    Flight().parse("20:30,+")
                ),
                progress = progress
            ),
            TimeTable(
                isTo = false,
                isWorkingDays = false,
                starDescription = "До Церкви",
                flightList = listOf(
                    Flight().parse("06:00,+"),
                    Flight().parse("07:00,-"),
                    Flight().parse("08:00,-"),
                    Flight().parse("09:00,+"),
                    Flight().parse("10:15,-"),
                    Flight().parse("12:15,-"),
                    Flight().parse("13:00,+"),
                    Flight().parse("13:55,+"),
                    Flight().parse("14:55,-"),
                    Flight().parse("15:50,+"),
                    Flight().parse("17:00,-"),
                    Flight().parse("17:50,+"),
                    Flight().parse("19:00,+"),
                    Flight().parse("20:15,-"),
                    Flight().parse("21:25,+")
                ),
                progress =progressBack
            )
        )
    )

}