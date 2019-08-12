package rostilav.mybus.data

import rostilav.mybus.domain.*

/*Нам нужно хранить
расписание
название расписаний
название маршрута
название конечных остановок
название остановок и время от старта до остановки
*/
/*



*val WDFlights= arrayOf<Flight>(
 Flight(4,52,true),
 Flight(5,10,true),
 Flight(5,30,true),
 Flight(6,0,true),
 Flight(6,30,true),
 Flight(6,54,true),
 Flight(7,35,false),
 Flight(8,0,false),
 Flight(9,0,true),
 Flight(11,0,true),
 Flight(12,0,false),
 Flight(13,0,false),
 Flight(14,0,true),
 Flight(14,40,true),
 Flight(15,0,true),
 Flight(15,30,true),
 Flight(16,5,true),
 Flight( 16,37,true),
 Flight(17,15,true),
 Flight(17,40, true),
 Flight(18,12,false),
 Flight(19,10,true),
 Flight(19,45,true),
 Flight(20,30,false)
)
val WDFlightsBack= arrayOf<Flight>(
 Flight(5,30,false),
 Flight(5,45,false),
 Flight(6,30,false),
 Flight(7,0,false),
 Flight(7,27,false),
 Flight(7,54,false),
 Flight(8,30,true),
 Flight(9,0,true),
 Flight(10,0,false),
 Flight(12,0,false),
 Flight(13,0,true),
 Flight(14,0,true),
 Flight(15,0,false),
 Flight(15,40,false),
 Flight(16,0,false),
 Flight(16,30,false),
 Flight(17,15,false),
 Flight(17,37,false),
 Flight(18,12,false),
 Flight(18,40,false),
 Flight(19,5,true),
 Flight(20,10,false),
 Flight(20,45,false),
 Flight(21,25,true)
)
val HDFlights= arrayOf<Flight>(
 Flight(5,20,true),
 Flight(5,55,false),
 Flight(8,0,true),
 Flight(9,15,false),
 Flight(11,15,false),
 Flight(12,0,true),
 Flight(13,0,true),
 Flight(13,55,false),
 Flight(14,50,true),
 Flight(16,0,false),
 Flight(16,50,true),
 Flight(18,0,true),
 Flight(19,15,false),
 Flight(20,30,true)

)
val HDFlightsBack= arrayOf<Flight>(
 Flight(6,0,true),
 Flight(7,0,false),
 Flight(8,0,false),
 Flight(9,0,true),
 Flight(10,15,false),
 Flight(12,15,false),
 Flight(13,0,true),
 Flight(13,55,true),
 Flight(14,55,false),
 Flight(15,50,true),
 Flight(17,0,false),
 Flight(17,50,true),
 Flight(19,0,true),
 Flight(20,15,false),
 Flight(21,25,true)
)
 */
class DataBase {
    private  val progress= arrayOf(
       RoadPoint(MTime(0,3), "ЦУМ"),
       RoadPoint(MTime(0,5), "Детский мир"),
       RoadPoint(MTime(0,12), "12 Сентября"),
       RoadPoint(MTime(0,16), "Аквамолл"),
       RoadPoint(MTime(0,18), "Пушкаревское Кольцо"),
       RoadPoint(MTime(0,22), "УАЗ"),
       RoadPoint(MTime(0,38), "Вещевой Рынок")
    )
    private  val progressBack= arrayOf(
        RoadPoint(MTime(0,17), "Вещевой Рынок"),
        RoadPoint(MTime(0,25), "УАЗ"),
        RoadPoint(MTime(0,32), "Пушкаревское Кольцо"),
        RoadPoint(MTime(0,43), "12 Сентября"),
        RoadPoint(MTime(0,55), "Детский мир"),
        RoadPoint(MTime(0,59), "ЦУМ")
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
                    Flight(MTime(4, 52), true),
                    Flight(MTime(5, 10), true),
                    Flight(MTime(5, 30), true),
                    Flight(MTime(6, 0), true),
                    Flight(MTime(6, 30), true),
                    Flight(MTime(6, 54), true),
                    Flight(MTime(7, 35), false),
                    Flight(MTime(8, 0), false),
                    Flight(MTime(9, 0), true),
                    Flight(MTime(11, 0), true),
                    Flight(MTime(12, 0), false),
                    Flight(MTime(13, 0), false),
                    Flight(MTime(14, 0), true),
                    Flight(MTime(14, 40), true),
                    Flight(MTime(15, 0), true),
                    Flight(MTime(15, 30), true),
                    Flight(MTime(16, 5), true),
                    Flight(MTime(16, 37), true),
                    Flight(MTime(17, 15), true),
                    Flight(MTime(17, 40), true),
                    Flight(MTime(18, 12), false),
                    Flight(MTime(19, 10), true),
                    Flight(MTime(19, 45), true),
                    Flight(MTime(20, 30), false)
                ),
                progress = progress
            ),
            TimeTable(
                isTo = false,
                isWorkingDays = true,
                starDescription = "От Церкви",
                flightList = listOf(
                    Flight(MTime(5, 30), false),
                    Flight(MTime(5, 45), false),
                    Flight(MTime(6, 30), false),
                    Flight(MTime(7, 0), false),
                    Flight(MTime(7, 27), false),
                    Flight(MTime(7, 54), false),
                    Flight(MTime(8, 30), true),
                    Flight(MTime(9, 0), true),
                    Flight(MTime(10, 0), false),
                    Flight(MTime(12, 0), false),
                    Flight(MTime(13, 0), true),
                    Flight(MTime(14, 0), true),
                    Flight(MTime(15, 0), false),
                    Flight(MTime(15, 40), false),
                    Flight(MTime(16, 0), false),
                    Flight(MTime(16, 30), false),
                    Flight(MTime(17, 15), false),
                    Flight(MTime(17, 37), false),
                    Flight(MTime(18, 12), false),
                    Flight(MTime(18, 40), false),
                    Flight(MTime(19, 5), true),
                    Flight(MTime(20, 10), false),
                    Flight(MTime(20, 45), false),
                    Flight(MTime(21, 25), true)
                ),
                progress =progressBack
            ),
            TimeTable(
                isTo = true,
                isWorkingDays = false,
                starDescription = "До Церкви",
                flightList = listOf(
                    Flight(MTime(5, 20), true),
                    Flight(MTime(5, 55), false),
                    Flight(MTime(8, 0), true),
                    Flight(MTime(9, 15), false),
                    Flight(MTime(11, 15), false),
                    Flight(MTime(12, 0), true),
                    Flight(MTime(13, 0), true),
                    Flight(MTime(13, 55), false),
                    Flight(MTime(14, 50), true),
                    Flight(MTime(16, 0), false),
                    Flight(MTime(16, 50), true),
                    Flight(MTime(18, 0), true),
                    Flight(MTime(19, 15), false),
                    Flight(MTime(20, 30), true)
                ),
                progress = progress
            ),
            TimeTable(
                isTo = false,
                isWorkingDays = false,
                starDescription = "До Церкви",
                flightList = listOf(
                    Flight(MTime(6, 0), true),
                    Flight(MTime(7, 0), false),
                    Flight(MTime(8, 0), false),
                    Flight(MTime(9, 0), true),
                    Flight(MTime(10, 15), false),
                    Flight(MTime(12, 15), false),
                    Flight(MTime(13, 0), true),
                    Flight(MTime(13, 55), true),
                    Flight(MTime(14, 55), false),
                    Flight(MTime(15, 50), true),
                    Flight(MTime(17, 0), false),
                    Flight(MTime(17, 50), true),
                    Flight(MTime(19, 0), true),
                    Flight(MTime(20, 15), false),
                    Flight(MTime(21, 25), true)
                ),
                progress =progressBack
            )
        )
    )

}