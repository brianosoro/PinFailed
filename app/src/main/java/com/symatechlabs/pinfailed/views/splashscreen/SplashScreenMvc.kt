package com.symatechlabs.pinfailed.views.splashscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.symatechlabs.pinfailed.databinding.SplashScreenBinding



class SplashScreenMvc(inflater: LayoutInflater, parent: ViewGroup?, appCompatActivity: AppCompatActivity)  : SplashScreenInterface{

    var rootView: View;
    var splashScreenBinding: SplashScreenBinding;
    var appCompatActivity: AppCompatActivity;

    init {
        splashScreenBinding =  SplashScreenBinding.inflate(inflater);
        rootView = splashScreenBinding.root;
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




}