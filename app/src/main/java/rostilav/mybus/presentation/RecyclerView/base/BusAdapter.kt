package rostilav.mybus.presentation.RecyclerView.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easyreader3.presentation.adapters.base.BaseAdapter
import com.example.easyreader3.presentation.adapters.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_flight.view.*
import rostilav.mybus.R
import rostilav.mybus.presentation.RecyclerView.Item

class BusAdapter() : BaseAdapter<Item>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_flight, parent, false)
        )

    class ViewHolder(itemView: View): BaseViewHolder<Item>(itemView) {
        override fun bind(model: Item)  {
                itemView.if_start_time.text = model.startTime
                itemView.if_start_point.text = model.startPoint
                itemView.if_flight_status.text = model.status
                itemView.if_finish_time.text = model.finishTime
                itemView.if_finish_point.text = model.finishPoint
                //  if (i.isActive) { this.setBackgroundResource(R.color.colorPrimaryDark) } else { this.setBackgroundResource(R.color.colorPrimary) }
                if (model.visibleBikeIcon) { itemView.if_img_bike.setImageResource(R.drawable.ic_directions_bike_black_24dp) }
                if (model.visibleHomeIcon) {  itemView.if_img_bike.setImageResource(R.drawable.ic_home_black_24dp) }
        }
    }

}