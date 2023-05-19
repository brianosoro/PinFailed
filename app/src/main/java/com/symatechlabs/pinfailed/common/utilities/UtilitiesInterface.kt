package com.symatechlabs.pinfailed.common.utilities

import android.content.Context
import androidx.fragment.app.Fragment


interface UtilitiesInterface {
    fun isAdminActive(): Boolean;
    fun setDeviceAdminSettings();
    fun requestPermissions(fragment: Fragment);
    fun hasPermissions(context: Context?, vararg permissions: String?): Boolean
    fun ignoreBatterOptimizations();
    fun getDateTime(): String?;
    fun takeSelfie();
    fun sendEmail(recipient: String, subject: String);
    fun openLink(link: String);
}