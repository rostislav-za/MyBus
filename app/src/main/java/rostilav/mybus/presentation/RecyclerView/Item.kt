package rostilav.mybus.presentation.RecyclerView

class Item(
    var startTime: String = "00:00",
    var startPoint: String = "ул. Пушкина",
    var finishTime: String = "22:22",
    var finishPoint: String = "дю Колотушкина",
    var visibleHomeIcon: Boolean = false,
    var visibleBikeIcon: Boolean = false,
    var status: String="Статус",
    var timeToStart: String = "00h00m",
    var isActive: Boolean = false,
    var info: String = "toHome info"

)