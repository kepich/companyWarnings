package ru.soft.companywarnings.db

import androidx.room.Dao
import androidx.room.Query
import ru.soft.companywarnings.warnings.CompanyWarning

@Dao
interface CompanyWarningDao {
    @Query("SELECT * FROM companywarning")
    fun getAll(): List<CompanyWarning>
}
