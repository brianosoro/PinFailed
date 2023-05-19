package com.symatechlabs.pinfailed.views.dashboard.fragments.home

import com.symatechlabs.pinfailed.views.common.BaseMvcInterface

interface HomeFragmentInterface : BaseMvcInterface {
     fun setListerners();
     fun setWelcomeMessage();
     fun  onResume();
}