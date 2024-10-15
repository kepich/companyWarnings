package ru.soft.companywarnings.modules

import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.soft.companywarnings.App
import ru.soft.companywarnings.db.AppDatabase
import ru.soft.companywarnings.db.CompanyWarningDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    private val dbName = "companywarnings"

    @Provides
    @Singleton
    fun db(app: App): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, dbName).build()

    @Provides
    @Singleton
    fun companyWarningDao(db: AppDatabase): CompanyWarningDao =
        db.companyWarningDao()
}