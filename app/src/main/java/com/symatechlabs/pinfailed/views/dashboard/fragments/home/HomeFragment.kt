package com.symatechlabs.pinfailed.views.dashboard.fragments.home;


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.symatechlabs.pinfailed.repository.PinRepository
import com.symatechlabs.pinfailed.views.dashboard.fragments.home.adapter.PinData
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import javax.inject.Inject


@WithFragmentBindings
@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var homeFragmentMvc: HomeFragmentFragmentMvc;
    @Inject
    lateinit var pinRepository: PinRepository;
    private val viewModel by viewModels<HomeFragmentViewModel>();
    var pinList = mutableListOf<PinData>();
    var LOG_TAG = "PIN_FAILED_";

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeFragmentMvc.setWelcomeMessage();


        this.apply {
            context?.let {  viewModel.observe(it, viewLifecycleOwner, homeFragmentMvc, pinList) }
        }


        return homeFragmentMvc.getRootView_();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeFragmentMvc = HomeFragmentFragmentMvc(LayoutInflater.from(context), null, this, viewModel, pinRepository);
        homeFragmentMvc.setListerners();

    }


    override fun onResume() {
        super.onResume()
        pinList.clear();
        homeFragmentMvc.onResume();
    }




}