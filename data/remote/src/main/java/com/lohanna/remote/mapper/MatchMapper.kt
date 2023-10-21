package com.lohanna.remote.mapper

import com.lohanna.domain.model.MatchDomain
import com.lohanna.domain.model.StadiumDomain
import com.lohanna.domain.model.Team
import com.lohanna.remote.model.MatchRemote
import com.lohanna.remote.model.StadiumRemote
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

internal fun List<MatchRemote>.toDomain() = map { it.toDomain() }

fun MatchRemote.toDomain(): MatchDomain {
    return MatchDomain(
        id = "$team1-$team2",
        name = name,
        team1 = team1.toTeam(),
        team2 = team2.toTeam(),
        stadium = stadium.toDomain(),
        date = date.toLocalDateTime(),
    )
}

private fun Date.toLocalDateTime(): LocalDateTime {
    return toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
}

private fun String.toTeam(): Team {
    return Team(
        flag = getTeamFlag(this),
        displayName = Locale("", this).isO3Country
    )
}

private fun getTeamFlag(team: String): String {
    return team.map {
        String(Character.toChars(it.code + 127397))
    }.joinToString("")
}

fun StadiumRemote.toDomain(): StadiumDomain {
    return StadiumDomain(
        name = name,
        image = image
    )
}
