package com.symatechlabs.pinfailed.data.source.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.symatechlabs.pinfailed.data.dao.PinDao
import com.symatechlabs.pinfailed.data.entities.Pin


@Database(entities = [Pin::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pinDao(): PinDao;

    companion object{
        const val DATABASE_NAME: String = "pinFailed_"
    }
}