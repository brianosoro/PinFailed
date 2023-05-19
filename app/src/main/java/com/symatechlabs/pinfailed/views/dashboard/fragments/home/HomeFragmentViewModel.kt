package com.symatechlabs.pinfailed.views.dashboard.fragments.home

import android.content.Context

import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager

import com.symatechlabs.pinfailed.data.entities.Pin
import com.symatechlabs.pinfailed.repository.PinRepository
import com.symatechlabs.pinfailed.views.dashboard.fragments.home.adapter.PinAdapter
import com.symatechlabs.pinfailed.views.dashboard.fragments.home.adapter.PinData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val pinRepository: PinRepository
) : ViewModel() {

    var pinLiveData = MutableLiveData<List<Pin>>();

    fun getPinAttempts(){
        viewModelScope.launch {
            pinLiveData.value = pinRepository.getPins();
        }
    }

    fun observe(context: Context, lifecycleOwner: LifecycleOwner, homeFragmentMvc: HomeFragmentFragmentMvc, pinList: MutableList<PinData>){
        pinList.clear();
        this.pinLiveData.observe(lifecycleOwner, Observer{

            for(pin in it){
                var pinData = PinData(
                    pin.id,
                    pin.date,
                    pin.desc
                )
                pinList.add(pinData);
            }
            var pinAdapter = PinAdapter(pinList, context);
            val layoutManager = LinearLayoutManager(context);
            homeFragmentMvc.homeFragmentBinding.contentMain.recyclerview.layoutManager = layoutManager;
            homeFragmentMvc.homeFragmentBinding.contentMain.recyclerview.adapter = pinAdapter;
            pinAdapter.notifyDataSetChanged();

        })
    }
}