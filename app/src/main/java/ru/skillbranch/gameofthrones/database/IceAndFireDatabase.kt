package ru.skillbranch.gameofthrones.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.skillbranch.gameofthrones.App
import ru.skillbranch.gameofthrones.BuildConfig
import ru.skillbranch.gameofthrones.data.local.entities.Character
import ru.skillbranch.gameofthrones.data.local.entities.CharacterFull
import ru.skillbranch.gameofthrones.data.local.entities.CharacterItem
import ru.skillbranch.gameofthrones.data.local.entities.House
import ru.skillbranch.gameofthrones.database.dao.CharactersDao
import ru.skillbranch.gameofthrones.database.dao.HouseDao

object DbManager {
    val db = Room.databaseBuilder(
        App.applicationContext(),
        IceAndFireDatabase::class.java,
        IceAndFireDatabase.DATABASE_NAME)
        .build()
}

@Database(
    entities = [House::class, Character::class],
    version = IceAndFireDatabase.DATABASE_VERSION,
    exportSchema = false,
    views = [CharacterItem::class, CharacterFull::class]
)
@TypeConverters(Converter::class)
abstract class IceAndFireDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = BuildConfig.APPLICATION_ID + ".db"
        const val DATABASE_VERSION = 1
    }

    abstract fun houseDao(): HouseDao
    abstract fun charactersDao(): CharactersDao
}