package rostilav.mybus.presentation.RecyclerView

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.dialog_flight_progress.view.*
import kotlinx.android.synthetic.main.item_flight.view.*
import rostilav.mybus.R
import rostilav.mybus.domain.toMTime
import rostilav.mybus.presentation.Presenter
import rostilav.mybus.presentation.ProgressDialogInfo
import kotlin.math.absoluteValue
/*проблемы
*
* 1) не удается программно назначать цвет фона для айтемов.
* Есть вариант
*     if (i.isActive) { this.setBackgroundResource(R.color.colorPrimaryDark) } else { this.setBackgroundResource(R.color.colorPrimary) }
* при использовании теряется настройка  скругления углов у кардвью
*
* */

class ItemsAdapter(var items: List<Item>) : RecyclerView.Adapter<ItemsAdapter.ItemsHolder>() {
    var mContext: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsHolder {
        mContext = parent.context
        //создаем view из файла интерфейса
        return ItemsHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_flight,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemsHolder, position: Int) {
        holder.bind(items.get(position), position)
        holder.itemView.setOnClickListener() {
            dialogIni(/* holder.itemView,*/
                Presenter().showDialog(items.get(position).startTime.toMTime())
            )
        }
    }

    fun refreshUsers(items: List<Item>) {
        this.items = items
        notifyDataSetChanged()
    }

    private fun dialogIni(/*itemView: View,*/content: ProgressDialogInfo) {

        val mDialog = LayoutInflater.from(mContext).inflate(R.layout.dialog_flight_progress, null)
        val mBuilder = AlertDialog.Builder(mContext)
            .setView(mDialog)
        mDialog.dfp_title.setText(content.title)
        mDialog.dfp_tv1.setText(content.tv1)
        mDialog.dfp_tv2.setText(content.tv2)
        val mAlertDialog = mBuilder.show()
    }

    class ItemsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("ResourceAsColor")
        fun bind(i: Item, position: Int) = with(itemView) {

            if_start_time.text = i.startTime
            if_start_point.text = i.startPoint
            if_flight_status.text = i.status
            if_finish_time.text = i.finishTime
            if_finish_point.text = i.finishPoint

          //  if (i.isActive) { this.setBackgroundResource(R.color.colorPrimaryDark) } else { this.setBackgroundResource(R.color.colorPrimary) }
            if (i.visibleBikeIcon) {if_img_bike.setImageResource(R.drawable.ic_directions_bike_black_24dp) }
            if (i.visibleHomeIcon) { if_img_bike.setImageResource(R.drawable.ic_home_black_24dp) }
//            list_item_tv_time.text = i.startTime  //загружаем текст в TextView
//            list_item_tv_time_to.text = i.timeToStart
//            if (i.visibleHomeIcon) list_item_tv_info.text = i.info
//            if (i.isActive==true) {list_item_colored.setBackgroundColor(Color.GRAY)}
//            else{ list_item_colored.setBackgroundColor(Color.DKGRAY)}


            //Glide.with(itemView).load(cat.image).into

        }
    }
}




