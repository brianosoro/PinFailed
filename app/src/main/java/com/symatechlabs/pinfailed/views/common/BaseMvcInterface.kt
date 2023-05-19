package com.symatechlabs.pinfailed.views.common

import android.content.Context
import android.view.View

interface BaseMvcInterface {

     fun getRootView_(): View;
     fun getContext(): Context;
}