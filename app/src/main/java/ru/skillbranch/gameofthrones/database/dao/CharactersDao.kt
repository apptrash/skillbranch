package ru.skillbranch.gameofthrones.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import ru.skillbranch.gameofthrones.data.local.entities.Character
import ru.skillbranch.gameofthrones.data.local.entities.CharacterFull
import ru.skillbranch.gameofthrones.data.local.entities.CharacterItem

@Dao
interface CharactersDao: BaseDao<Character> {
    @Query("SELECT * FROM CharacterItem WHERE house = :title")
    fun findCharacters(title: String): LiveData<List<CharacterItem>>

    @Query("SELECT * FROM CharacterItem WHERE house = :title")
    fun findCharactersList(title: String): List<CharacterItem>

    @Query("SELECT * FROM CharacterFull WHERE id = :characterId")
    fun findCharacter(characterId: String): LiveData<CharacterFull>

    @Query("SELECT * FROM CharacterFull WHERE id = :characterId")
    fun findCharacterFull(characterId: String): CharacterFull

    @Transaction
    fun upsert(characters: List<Character>) {
        insert(characters)
            .mapIndexed { index, l -> if (l == -1L) characters[index] else null }
            .filterNotNull()
            .also { if (it.isNotEmpty()) update(it) }
    }
}
