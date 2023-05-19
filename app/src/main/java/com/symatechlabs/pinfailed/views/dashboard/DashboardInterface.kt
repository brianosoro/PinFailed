package com.symatechlabs.pinfailed.views.dashboard

import com.symatechlabs.pinfailed.views.common.BaseMvcInterface

interface DashboardInterface : BaseMvcInterface {

    fun setListerners();
    fun setBottomNavigationView();
}