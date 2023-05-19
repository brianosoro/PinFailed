package com.symatechlabs.pinfailed.views.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.symatechlabs.pinfailed.R
import com.symatechlabs.pinfailed.databinding.ActivityMainBinding



class DashboardMvc(inflater: LayoutInflater, parent: ViewGroup?, appCompatActivity: AppCompatActivity)  :
    DashboardInterface {

    var rootView: View;
    var activityMainBinding: ActivityMainBinding;
    lateinit var navController: NavController;
    var appCompatActivity: AppCompatActivity;

    init {
        activityMainBinding =  ActivityMainBinding.inflate(inflater);
        rootView = activityMainBinding.root;
        this.appCompatActivity = appCompatActivity;
    }

    override fun getRootView_(): View {
            return rootView;
    }

    override fun getContext(): Context {
        return rootView.context;
    }

    override fun setListerners() {

    }

    override fun setBottomNavigationView(){
        navController = Navigation.findNavController(this.appCompatActivity, R.id.activity_main_nav_host_fragment)
        setupWithNavController(activityMainBinding.bottomNavigationView,navController)
    }


}