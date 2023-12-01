package com.symatechlabs.pinfailed.views.dashboard.fragments.home

import android.Manifest
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.symatechlabs.pinfailed.common.Constants.WHY_ENABLE_DEVICE_ADMIN_LINK
import com.symatechlabs.pinfailed.common.utilities.Utilities
import com.symatechlabs.pinfailed.databinding.HomeFragmentBinding
import com.symatechlabs.pinfailed.repository.PinRepository


class HomeFragmentFragmentMvc(
    inflater: LayoutInflater, parent: ViewGroup?, fragment: Fragment,
    homeFragmentViewModel: HomeFragmentViewModel, pinRepository: PinRepository
) :
    HomeFragmentInterface {


    var rootView: View;
    var homeFragmentBinding: HomeFragmentBinding;
    var homeFragmentViewModel: HomeFragmentViewModel;
    var utilities: Utilities;
    var fragment: Fragment;
    var pinRepository: PinRepository;

    init {
        homeFragmentBinding = HomeFragmentBinding.inflate(inflater);
        rootView = homeFragmentBinding.root;
        this.homeFragmentViewModel = homeFragmentViewModel;
        utilities = Utilities(getContext());
        this.fragment = fragment;
        this.pinRepository = pinRepository;
    }

    override
    fun setListerners() {
        homeFragmentBinding.contentMain.enableAdmin.setOnClickListener {
            if (!utilities.isAdminActive()) {
                utilities.setDeviceAdminSettings();
            }
        }
        homeFragmentBinding.contentMain.why.setOnClickListener {
            utilities.openLink(WHY_ENABLE_DEVICE_ADMIN_LINK);
        }
        if (!utilities.hasPermissions(
                getContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.BIND_DEVICE_ADMIN,
                Manifest.permission.ACCESS_NOTIFICATION_POLICY,
                Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE,
                Manifest.permission.CAMERA,
                Manifest.permission.SYSTEM_ALERT_WINDOW
            )
        ) {
            utilities.requestPermissions(fragment);
        }
    }

    override
    fun setWelcomeMessage() {

    }


    override
    fun onResume() {

        this.homeFragmentViewModel.getPinAttempts();

        if (utilities.isAdminActive()) {
            homeFragmentBinding.contentMain.enableAdmin.visibility = AppCompatButton.GONE;
            homeFragmentBinding.contentMain.why.visibility = TextView.GONE;
            homeFragmentBinding.contentMain.recyclerview.visibility = RecyclerView.VISIBLE;
            if (this.pinRepository.getCount() == 0) {
                homeFragmentBinding.contentMain.noPinsLayout.visibility = LinearLayout.VISIBLE
            }else{
                homeFragmentBinding.contentMain.noPinsLayout.visibility = LinearLayout.GONE
            }
        } else {
            homeFragmentBinding.contentMain.enableAdmin.visibility = AppCompatButton.VISIBLE;
            homeFragmentBinding.contentMain.recyclerview.visibility = RecyclerView.GONE;
        }
    }


    override fun getRootView_(): View {
        return rootView;
    }

    override fun getContext(): Context {
        return rootView.context;
    }


}