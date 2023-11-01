package com.example.movieapp.data
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
class DataConverter {
    @TypeConverter
    fun grnIdToJson(list: List<Int>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun jsonToGrnId(json: String): List<Int> {
        val type = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(json, type)
    }
}