package ru.soft.companywarnings

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.soft.companywarnings.db.CompanyWarningDao
import ru.soft.companywarnings.model.CompanyWarning
import ru.soft.companywarnings.model.Priority
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {
    @Inject
    lateinit var companyWarningsDao: CompanyWarningDao

    override fun onCreate() {
        super.onCreate()
        val applicationScope = CoroutineScope(SupervisorJob())

        applicationScope.launch {
            companyWarningsDao.init(
                listOf(
                    CompanyWarning(1, "title1","description1", "picture1", Priority.LOW),
                    CompanyWarning(1, "title2","description2", "picture2", Priority.MEDIUM),
                    CompanyWarning(1, "title3","description3", "picture3", Priority.HIGH)
                )
            )
        }
    }
}