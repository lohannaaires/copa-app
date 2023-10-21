package com.lohanna.remote.source

import com.lohanna.data.source.MatchesDataSource
import com.lohanna.domain.model.MatchDomain
import com.lohanna.remote.extensions.getOrThrowDomainError
import com.lohanna.remote.mapper.toDomain
import com.lohanna.remote.services.MatchesServices
import javax.inject.Inject

class MatchDataSourceRemote @Inject constructor(
    private val service: MatchesServices
) : MatchesDataSource.Remote {

    override suspend fun getMatches(): List<MatchDomain> {
        return runCatching {
            service.getMatches()
        }.getOrThrowDomainError().toDomain()
    }
}