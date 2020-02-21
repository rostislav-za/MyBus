package rostilav.mybus.presentation

import rostilav.mybus.domain.MTime
import rostilav.mybus.domain.Model


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

    fun showList()= model.getFlightsList()
    fun notifyClicked(){}
    fun showDialog(time:MTime): ProgressDialogInfo =model.getProgressDialogInfo(time)
    fun showToast(){}

 fun showButton(btnType:Int):String{return model.getBtnText(btnType)}
}