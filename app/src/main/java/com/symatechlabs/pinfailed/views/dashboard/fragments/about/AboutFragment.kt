package com.symatechlabs.pinfailed.views.dashboard.fragments.about;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.symatechlabs.pinfailed.data.dao.PinDao
import com.symatechlabs.pinfailed.views.dashboard.fragments.home.adapter.PinData
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import javax.inject.Inject

@WithFragmentBindings
@AndroidEntryPoint
class AboutFragment : Fragment() {

    lateinit var aboutFragmentMvc: AboutFragmentMvc;
    @Inject
    lateinit var pinDao: PinDao;


    var courseList = mutableListOf<PinData>();

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        aboutFragmentMvc = AboutFragmentMvc(LayoutInflater.from(context), null);
        aboutFragmentMvc.setListerners();

        return aboutFragmentMvc.getRootView_();
    }

}