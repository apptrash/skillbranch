package ru.skillbranch.gameofthrones.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import ru.skillbranch.gameofthrones.data.local.entities.House

@Dao
interface HouseDao: BaseDao<House> {
    @Query("SELECT COUNT(*) FROM houses")
    suspend fun recordsCount(): Int

    @Transaction
    fun upsert(houses: List<House>) {
        insert(houses)
            .mapIndexed { index, l -> if (l == -1L) houses[index] else null }
            .filterNotNull()
            .also { if (it.isNotEmpty()) update(it) }
    }
}
