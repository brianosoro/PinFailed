package com.symatechlabs.pinfailed.data.dao

import androidx.room.*
import com.symatechlabs.pinfailed.data.entities.Pin
import com.symatechlabs.pinfailed.views.dashboard.fragments.home.adapter.PinData



@Dao
interface PinDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertPin(pin: Pin): Long;

    @Query("DELETE FROM pin")
    fun deletePins()

    @Query("SELECT * FROM pin ORDER BY id DESC LIMIT 40")
    fun getSubmittedPin(): List<Pin>;

    @Query("SELECT COUNT(id) FROM pin")
    fun getCount(): Int;

}