package ru.soft.companywarnings.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.soft.companywarnings.db.AppDatabase
import ru.soft.companywarnings.db.CompanyWarningDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    private val dbName = "companywarnings"

    @Singleton
    @Provides
    fun db(@ApplicationContext app: Context): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, dbName).build()

    @Provides
    @Singleton
    fun companyWarningDao(db: AppDatabase): CompanyWarningDao =
        db.companyWarningDao()
}