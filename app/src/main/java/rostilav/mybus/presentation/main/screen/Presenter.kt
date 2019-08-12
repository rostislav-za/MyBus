package rostilav.mybus.presentation.main.screen

import rostilav.mybus.domain.MTime
import rostilav.mybus.domain.Model

class Item(
    var startTime: String = "00:00",
    var timeToStart: String = "00h00m",
    var isOutdated: Boolean = false,
    var info: String = "star info",
    var taged: Boolean = false
)
class ProgressDialogInfo(
    val title:String="title",
   val tv1:String="",
   val tv2:String="")
/*Презентер */

//может поучить  клик на кнопку дня
//может получить клик на кнопку направления
//может lать адаптеру список
//мржет дать диалогу  список или три тексвью
/*показать диалог*/
class Presenter(){
private val model:Model=Model()

    fun button1Clicked()=model.isToSwitcher()

    fun button2Clicked()=model.isWDSwitcher()



    fun showList()= ItemsAdapter(model.getItems())
    fun notifyClicked(){}
    fun showDialog(time:MTime): ProgressDialogInfo =model.getProgressDialogInfo(time)
    fun showToast(){}

 fun showButton(btnType:Int):String{return model.getBtnText(btnType)}
}