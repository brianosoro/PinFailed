package com.symatechlabs.pinfailed.views.dashboard.fragments.about

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.symatechlabs.pinfailed.common.Constants.EMAIL_ADDRESS
import com.symatechlabs.pinfailed.common.Constants.WEBSITE_LINK
import com.symatechlabs.pinfailed.common.utilities.Utilities
import com.symatechlabs.pinfailed.databinding.AboutAppBinding


class  AboutFragmentMvc (inflater: LayoutInflater, parent: ViewGroup?)  : AboutInterface{


    var rootView: View;
    var aboutAppBinding: AboutAppBinding;
    var utilities: Utilities;


    init {
        aboutAppBinding =  AboutAppBinding.inflate(inflater);
        rootView = aboutAppBinding.root;
        this.utilities = Utilities(getContext());
    }

    override fun setListerners() {
        aboutAppBinding.email.setOnClickListener{
            this.utilities.sendEmail(EMAIL_ADDRESS, "Contact Symatech Labs Ltd");
        }
        aboutAppBinding.website.setOnClickListener{
            this.utilities.openLink(WEBSITE_LINK);
        }
    }

    override fun getRootView_(): View {
            return rootView;
    }

    override fun getContext(): Context {
        return rootView.context;
    }




}