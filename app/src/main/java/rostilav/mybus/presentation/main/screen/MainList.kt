package rostilav.mybus.presentation.main.screen

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.dialog_flight_progress.view.*
import kotlinx.android.synthetic.main.list_item.view.*
import rostilav.mybus.R
import rostilav.mybus.domain.toMTime


class ItemsAdapter(var items: List<Item>/*, var array: Array<RoadPoint>*/) :
    RecyclerView.Adapter<ItemsAdapter.ItemsHolder>() {
    var mContext: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsHolder {
        mContext = parent.context
        //создаем view из файла интерфейса
        return ItemsHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

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
        mDialog.dialog_title.setText(content.title)
        mDialog.dialog_text.setText(content.tv1)
        mDialog.dialog_text2.setText(content.tv2)
        val mAlertDialog = mBuilder.show()
    }

    class ItemsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("ResourceAsColor")
        fun bind(item: Item, position: Int) = with(itemView) {
            list_item_tv_time.text = item.startTime  //загружаем текст в TextView
            list_item_tv_time_to.text = item.timeToStart
            if (item.taged) list_item_tv_info.text = item.info
            if (item.isOutdated) list_item_colored.setBackgroundColor(R.color.colorLightBlue)
            else list_item_colored.setBackgroundColor(R.color.colorPrimaryLight)


            //Glide.with(itemView).load(cat.image).into(imageView)
        }
    }
}




