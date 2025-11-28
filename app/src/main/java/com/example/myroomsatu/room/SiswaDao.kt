package com.example.myroomsatu.room

import androidx.room.Dao

@Dao
interface SiswaDao {
    @Query(value= "SELECT * from tblSiswa ORDER BY nama ASC")
    fun getAllSiswa(): Flow<List<Siswa>>


    @Insert(onConflict = onConflictStrategy.IGNORE)
    suspend fun insert(siswa: Siswa)
}