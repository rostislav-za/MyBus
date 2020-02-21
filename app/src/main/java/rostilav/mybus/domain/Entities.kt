package rostilav.mybus.domain

import java.util.*

fun Date.isWorkingDays(): Boolean = when (this.toString().split(" ")[0]) {
    "Sun", "Sat" -> false
    else -> true
}

fun String.toMTime() = MTime(h = this.split(":")[0].toInt(), m = this.split(":")[1].toInt())
class MTime(h: Int, m: Int) {
    val h: Int
    val m: Int

    init {
        this.h = Math.abs(h) % 24
        this.m = Math.abs(m) % 60
    }

    operator fun plus(other: MTime) = MTime(
        h = (h + other.h + (m + other.m) / 60) % 24,
        m = (m + other.m) % 60
    )

    operator fun minus(other: MTime): MTime {
        var rm = m - other.m
        var rh = h - other.h
        if (rm < 0) {
            rm += 60;rh--
        }
        if (rh < 0) rh += 24
        return MTime(h = rh, m = rm)
    }

    fun isBigger(other: MTime): Boolean = this.h * 100 + this.m > other.h * 100 + other.m


    fun myToString() = this.h.toString() + ":" + this.m.toString()


}


class Flight(
    val time: MTime = MTime(0, 0),
    val toHome: Boolean = false,
    val bigBus: Boolean = false

)

class RoadPoint(val time: MTime, val place: String)
class TimeTable(
    val isWorkingDays: Boolean = false,
    val isTo: Boolean = false,
    val starDescription: String = "",
    var flightList: List<Flight>,
    val progress: Array<RoadPoint>
)

class Itinerary(
    val title: String = "",
    val startPoint: String = "",
    val finishPoint: String = "",
    val timeTableArray: Array<TimeTable>
)

fun Date.toMTime() = MTime(
    h = this.toString().split(" ")[3].split(":")[0].toInt(),
    m = this.toString().split(" ")[3].split(":")[1].toInt()
)

fun Model.Flights() = itineraryFromDB.timeTableArray[index()].flightList
fun Model.StarDescription() = itineraryFromDB.timeTableArray[index()].starDescription
fun Model.Progress() = itineraryFromDB.timeTableArray[index()].progress
