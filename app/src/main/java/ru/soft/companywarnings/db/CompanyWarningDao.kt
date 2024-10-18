package ru.soft.companywarnings.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.soft.companywarnings.model.CompanyWarning

@Dao
interface CompanyWarningDao {
    @Query("SELECT * FROM companywarning")
    fun getAll(): Flow<List<CompanyWarning>>

    @Query("SELECT * FROM companywarning WHERE id=(:id)")
    fun getById(id: Int): Flow<CompanyWarning>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun init(warnings: List<CompanyWarning>)
}
