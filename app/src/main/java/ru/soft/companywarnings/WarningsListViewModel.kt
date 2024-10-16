package ru.soft.companywarnings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.soft.companywarnings.db.CompanyWarningDao
import ru.soft.companywarnings.warnings.CompanyWarning
import javax.inject.Inject

@HiltViewModel
class WarningsListViewModel
@Inject constructor(val dao: CompanyWarningDao) : ViewModel() {
    fun getWarningList(): Flow<List<CompanyWarning>> = dao.getAll()
}