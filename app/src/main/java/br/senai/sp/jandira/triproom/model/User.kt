package br.senai.sp.jandira.triproom.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tbl_user")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "user_name") var username: String = "",
    var password: String = "",
    var email: String = "",
    var phone: String = "",
    @ColumnInfo(name = "is_over_18" )var isOver18: Boolean = false
)
