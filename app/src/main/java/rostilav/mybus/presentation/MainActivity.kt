package rostilav.mybus.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.botton_bar.*
import rostilav.mybus.R


class MainActivity : AppCompatActivity() {

    val presenter: Presenter =
        Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewID.adapter = presenter.showList()
        recyclerViewID.layoutManager = LinearLayoutManager(this)

        am_bb_from_to_btn.setOnClickListener { presenter.button1Clicked();Update() }
        am_bb_work_holydays_btn.setOnClickListener { presenter.button2Clicked();Update() }
        am_bb_from_to_btn.text = presenter.showButton(1)
        am_bb_work_holydays_btn.text = presenter.showButton(2)


    }

    fun Update() {
        am_bb_from_to_btn.text = presenter.showButton(1)
        am_bb_work_holydays_btn.text = presenter.showButton(2)
        recyclerViewID.adapter = presenter.showList()

    }


}


