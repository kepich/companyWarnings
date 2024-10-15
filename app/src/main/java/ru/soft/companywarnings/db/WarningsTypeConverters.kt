package ru.soft.companywarnings.db

import androidx.room.TypeConverter
import ru.soft.companywarnings.warnings.Priority

class WarningsTypeConverters {
    @TypeConverter
    fun fromString2Priority(value: String) =
        Priority.valueOf(value)

    @TypeConverter
    fun fromPriority2String(value: Priority) =
        value.toString()
}