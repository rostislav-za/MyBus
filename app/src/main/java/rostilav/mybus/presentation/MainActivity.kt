package rostilav.mybus.presentation

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.example.easyreader3.presentation.adapters.base.BaseAdapterCallback
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.botton_bar.*
import kotlinx.android.synthetic.main.dialog_flight_progress.view.*
import rostilav.mybus.R
import rostilav.mybus.domain.toMTime
import rostilav.mybus.presentation.list.Item
import rostilav.mybus.presentation.list.BusAdapter


class MainActivity : AppCompatActivity() {
    val newdata = ArrayList<Item>()
    val busAdapter = BusAdapter()
    val presenter: Presenter =
        Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){
        recyclerViewID.layoutManager = LinearLayoutManager(this)
        recyclerViewID.adapter = busAdapter
        busAdapter.setList(presenter.showList())
        am_bb_from_to_btn.setOnClickListener { presenter.button1Clicked();Update() }
        am_bb_work_holydays_btn.setOnClickListener { presenter.button2Clicked();Update() }
        am_bb_from_to_btn.text = presenter.showButton(1)
        am_bb_work_holydays_btn.text = presenter.showButton(2)
        busAdapter.attachCallback(object : BaseAdapterCallback<Item> {
            override fun onItemClick(model: Item, view: View) {
                itemClicked(model, view)
            }

            override fun onLongClick(model: Item, view: View): Boolean {
                itemLongClicked()
                return true
            }
        })
    }


    fun itemClicked(model: Item, view: View) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        dialogIni(presenter.showDialog(model.startTime.toMTime()))
    }

    fun itemLongClicked() {
        Toast.makeText(this, "LongClicked", Toast.LENGTH_SHORT).show()
    }

    private fun dialogIni(/*itemView: View,*/content: ProgressDialogInfo) {

        val mDialog = LayoutInflater.from(this).inflate(R.layout.dialog_flight_progress, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialog)
        mDialog.dfp_title.setText(content.title)
        mDialog.dfp_tv1.setText(content.tv1)
        mDialog.dfp_tv2.setText(content.tv2)
        val mAlertDialog = mBuilder.show()
    }


    fun Update() {
        am_bb_from_to_btn.text = presenter.showButton(1)
        am_bb_work_holydays_btn.text = presenter.showButton(2)
        busAdapter.setList(presenter.showList())

    }


}


