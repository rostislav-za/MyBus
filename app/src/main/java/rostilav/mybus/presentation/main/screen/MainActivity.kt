package rostilav.mybus.presentation.main.screen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

import rostilav.mybus.R


class MainActivity : AppCompatActivity() {

    val presenter: Presenter =
        Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewID.adapter = presenter.showList()
        recyclerViewID.layoutManager = LinearLayoutManager(this)

        activity_main_tv1.setOnClickListener { presenter.button1Clicked();Update() }
        activity_main_tv2.setOnClickListener { presenter.button2Clicked();Update() }
        activity_main_tv1.text = presenter.showButton(1)
        activity_main_tv2.text = presenter.showButton(2)


    }

    fun Update() {
        activity_main_tv1.text = presenter.showButton(1)
        activity_main_tv2.text = presenter.showButton(2)
        recyclerViewID.adapter = presenter.showList()

    }


}


