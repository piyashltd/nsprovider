package com.example.myapplication

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.ExtractorLink
import com.lagradost.cloudstream3.utils.Qualities
import com.lagradost.cloudstream3.utils.AppUtils.parseJson

class MyCustomProvider : MainAPI() {
    override var name = "My JSON Provider"
    override val hasMainPage = true
    override val supportedTypes = setOf(TvType.Movie, TvType.TvSeries)
    
    // আপনার JSON ফাইলের ডিরেক্ট লিংকটি এখানে বসান
    override var mainUrl = "https://raw.githubusercontent.com/piyashltd/nsprovider/refs/heads/main/data.json"

    private suspend fun getConfig(): CustomConfig? {
        val response = app.get(mainUrl).text
        return parseJson<CustomConfig>(response)
    }

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse? {
        val config = getConfig() ?: return null
        val homePageList = mutableListOf<HomePageList>()

        config.categories.forEach { category ->
            val list = category.items.mapNotNull { id ->
                val item = config.contentDetails[id] ?: return@mapNotNull null
                if (item.type == "movie") {
                    MovieSearchResponse(item.title, id, this.name, TvType.Movie, item.posterUrl, item.year)
                } else {
                    TvSeriesSearchResponse(item.title, id, this.name, TvType.TvSeries, item.posterUrl, item.year, null)
                }
            }
            if (list.isNotEmpty()) homePageList.add(HomePageList(category.title, list))
        }
        return HomePageResponse(homePageList)
    }

    override suspend fun load(url: String): LoadResponse? {
        val config = getConfig() ?: return null
        val item = config.contentDetails[url] ?: return null
        val actors = item.cast?.map { ActorData(Actor(it.name, it.imageUrl)) }
        
        if (item.type == "movie") {
            return newMovieLoadResponse(item.title, url, TvType.Movie, url) {
                this.posterUrl = item.posterUrl
                this.backgroundPosterUrl = item.backgroundUrl
                this.year = item.year
                this.plot = item.description
                this.tags = item.genres
                this.rating = item.rating?.toInt()
                this.duration = item.runtime
                this.actors = actors
            }
        } else {
            val episodes = item.episodes?.map { ep ->
                Episode(ep.videoLink ?: "", ep.title, ep.seasonNumber, ep.episodeNumber, ep.thumbnailUrl, ep.description)
            } ?: emptyList()
            return newTvSeriesLoadResponse(item.title, url, TvType.TvSeries, episodes) {
                this.posterUrl = item.posterUrl
                this.backgroundPosterUrl = item.backgroundUrl
                this.year = item.year
                this.plot = item.description
                this.tags = item.genres
                this.rating = item.rating?.toInt()
                this.duration = item.runtime
                this.actors = actors
            }
        }
    }

    override suspend fun loadLinks(data: String, isCasting: Boolean, subtitleCallback: (SubtitleFile) -> Unit, callback: (ExtractorLink) -> Unit): Boolean {
        var videoUrl = data
        if (!data.startsWith("http")) {
            val config = getConfig() ?: return false
            videoUrl = config.contentDetails[data]?.videoLink ?: return false
        }
        callback.invoke(ExtractorLink(source = name, name = name, url = videoUrl, referer = "", quality = Qualities.Unknown.value, isM3u8 = videoUrl.contains(".m3u8")))
        return true
    }
}
