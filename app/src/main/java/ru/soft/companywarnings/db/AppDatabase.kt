package ru.soft.companywarnings.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.soft.companywarnings.model.CompanyWarning

@Database(entities = [CompanyWarning::class], version = 1)
@TypeConverters(WarningsTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun companyWarningDao(): CompanyWarningDao
}