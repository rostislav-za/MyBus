package rostilav.mybus.domain

import rostilav.mybus.data.DataBase
import rostilav.mybus.data.getDataForBus
import rostilav.mybus.presentation.RecyclerView.Item
import rostilav.mybus.presentation.ProgressDialogInfo
import java.util.*

class Model() {
    internal val WORKINGDAYS: String = "БУДНИ"
    internal val HOLYDAYS: String = "ВЫХОДНЫЕ"
    internal var db: DataBase = DataBase()
    internal var isTo: Boolean = false
    internal var isWD: Boolean = Date().isWorkingDays()
    internal val itineraryFromDB: Itinerary = db.getDataForBus()

    fun index(): Int = when (listOf(isWD, isTo)) {
        listOf(true, true) -> 0
        listOf(true, false) -> 1
        listOf(false, true) -> 2
        listOf(false, false) -> 3
        else -> 7
    }

    fun timeNow(): MTime = Date().toMTime()
    fun getFlightsList(): List<Item> {
        val input = Flights()

        return List<Item>(input.size) { i ->
            Item(
                startTime = input[i].time.myToString(),
                startPoint = if (!isTo) { "Обелиск" } else { "Центробанк" },
                status = if(!timeNow().isBigger(input[i].time)){"(На маршруте)"}else{"(Ушел)"},
                finishPoint = if (isTo) { "Обелиск" } else { "Центробанк" },
                finishTime = (input[i].time + MTime(1, 0)).myToString(),
                visibleBikeIcon = input[i].bigBus,
                visibleHomeIcon = !input[i].toHome,//ВНИМАНИЕ КОСТЫЛЬ!
                // ГДЕ-ТО ИНВЕРСИРУЕТСЯ ЗНАЧЕНИЕ  ЗВЕЗДОЧЕК ИЗ БД. ЗДЕСЬ ОНО ИНВЕРСИРОВАНО ОБРАТНО. НАЙТИ, ИСПРАВИТЬ


                //timeToStart = (input[i].time - timeNow()).myToString(),
                isActive = timeNow().isBigger(input[i].time),
                info = StarDescription()
            )
        }
    }

    fun getProgressDialogInfo(time: MTime): ProgressDialogInfo {
        /*получает на вход время отправления и составляет по нему информацию для диалоговолго окна
        название рейса
        график прохождения маршрута
          текствью с пройденными пунктами
          текствью с непройденными пунктами */
        var a: Array<RoadPoint> = Progress()
        var newln: String = """
"""
        var s1: String = """"""
        var s2: String = """"""
        for (i in 0..a.size - 1) {
            a[i] = RoadPoint(
                time = a[i].time + time,
                place = a[i].place
            )
            if (a[i].time.isBigger(timeNow())) s2 += newln + a[i].time.myToString() + " -" + a[i].place
            else s1 += newln + a[i].time.myToString() + " -" + a[i].place
        }
        return ProgressDialogInfo(
            title = "Отправление " + time.myToString(),
            tv1 = s1,
            tv2 = s2
        )
    }

    fun isToSwitcher() {
        isTo = !isTo
    }

    fun isWDSwitcher() {
        isWD = !isWD
    }

    fun getBtnText(btnType: Int): String {
        return when (listOf(btnType, index())) {
            listOf(1, 2), listOf(1, 0) -> itineraryFromDB.startPoint
            listOf(1, 1), listOf(1, 3) -> itineraryFromDB.finishPoint
            listOf(2, 0), listOf(2, 1) -> WORKINGDAYS
            listOf(2, 2), listOf(2, 3) -> HOLYDAYS
            else -> "Error"
        }
    }
}