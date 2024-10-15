package ru.soft.companywarnings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.soft.companywarnings.db.CompanyWarningDao
import javax.inject.Inject

@HiltViewModel
class WarningsListViewModel @Inject constructor(val companyWarningDao: CompanyWarningDao) : ViewModel() {
    // TODO: Implement the ViewModel
    val warningList = companyWarningDao.getAll()
}