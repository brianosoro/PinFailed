package com.symatechlabs.pinfailed.repository

import com.symatechlabs.pinfailed.data.dao.PinDao
import com.symatechlabs.pinfailed.data.entities.Pin
import com.symatechlabs.pinfailed.views.dashboard.fragments.home.adapter.PinData
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class PinRepository @Inject constructor(
    private val pinDao: PinDao
)  {

    fun deletePins(){
        pinDao.deletePins();
    }

    fun insertPin(pin: Pin){
        pinDao.insertPin(pin);
    }

    fun getCount() : Int{
        return pinDao.getCount();
    }

    fun getPins() : List<Pin>{
        return pinDao.getSubmittedPin();
    }




}