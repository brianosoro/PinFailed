package com.symatechlabs.pinfailed.views.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.symatechlabs.pinfailed.views.dashboard.DashboardMvc
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
public class Dashboard: AppCompatActivity() {

    lateinit var dashboardMvc: DashboardMvc;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashboardMvc = DashboardMvc(LayoutInflater.from(this), null, this);
        setContentView(dashboardMvc.getRootView_())
        dashboardMvc.setBottomNavigationView();
        dashboardMvc.setListerners();

    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val homeIntent = Intent(Intent.ACTION_MAIN)
            homeIntent.addCategory(Intent.CATEGORY_HOME)
            homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(homeIntent)
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}