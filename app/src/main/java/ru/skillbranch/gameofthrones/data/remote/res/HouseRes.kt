package ru.skillbranch.gameofthrones.data.remote.res

import ru.skillbranch.gameofthrones.HouseType
import ru.skillbranch.gameofthrones.data.local.entities.House

data class HouseRes(
    val url: String,
    val name: String,
    val region: String,
    val coatOfArms: String,
    val words: String,
    val titles: List<String> = listOf(),
    val seats: List<String> = listOf(),
    val currentLord: String,
    val heir: String,
    val overlord: String,
    val founded: String,
    val founder: String,
    val diedOut: String,
    val ancestralWeapons: List<String> = listOf(),
    val cadetBranches: List<Any> = listOf(),
    val swornMembers: List<String> = listOf()
) : IRes {
    override val id: String
        get() = url.lastSegment()

    val shortName: String
        get() = name.substring("House ".length, name.indexOf(" of"))

    val members: List<String>
        get() = swornMembers.map { it.lastSegment() }
}

fun HouseRes.toHouse(): House {
    return House(
        id = HouseType.fromString(shortName),
        name,
        region,
        coatOfArms,
        words,
        titles,
        seats,
        currentLord,
        heir,
        overlord,
        founded,
        founder,
        diedOut,
        ancestralWeapons
    )
}