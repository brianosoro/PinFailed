package com.symatechlabs.pinfailed.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pin")
data class Pin(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "desc") val desc: String?,
    @ColumnInfo(name = "date_time") val date: String?,
)
