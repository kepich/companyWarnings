package ru.soft.companywarnings.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * ID номер; заголовок; описание проблемы; пиктограммы наличия прикрепленного изображения; иконка уровня приоритета
 */
@Entity
data class CompanyWarning(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "picture") val picture: String,
    @ColumnInfo(name = "priority") val priority: Priority
)