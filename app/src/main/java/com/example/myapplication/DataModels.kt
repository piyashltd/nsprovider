package com.example.myapplication

import com.fasterxml.jackson.annotation.JsonProperty

data class CustomConfig(
    @JsonProperty("categories") val categories: List<CustomCategory>,
    @JsonProperty("content_details") val contentDetails: Map<String, CustomContent>
)

data class CustomCategory(
    @JsonProperty("title") val title: String,
    @JsonProperty("items") val items: List<String>
)

data class CustomContent(
    @JsonProperty("type") val type: String,
    @JsonProperty("title") val title: String,
    @JsonProperty("poster_url") val posterUrl: String?,
    @JsonProperty("background_url") val backgroundUrl: String?,
    @JsonProperty("description") val description: String?,
    @JsonProperty("year") val year: Int?,
    @JsonProperty("rating") val rating: Double?,
    @JsonProperty("runtime") val runtime: Int?,
    @JsonProperty("genres") val genres: List<String>?,
    @JsonProperty("trailer_url") val trailerUrl: String?,
    @JsonProperty("director") val director: String?,
    @JsonProperty("cast") val cast: List<CustomCast>?,
    @JsonProperty("video_link") val videoLink: String?,
    @JsonProperty("episodes") val episodes: List<CustomEpisode>?
)

data class CustomCast(
    @JsonProperty("name") val name: String,
    @JsonProperty("image_url") val imageUrl: String?
)

data class CustomEpisode(
    @JsonProperty("season_number") val seasonNumber: Int,
    @JsonProperty("episode_number") val episodeNumber: Int,
    @JsonProperty("title") val title: String?,
    @JsonProperty("description") val description: String?,
    @JsonProperty("thumbnail_url") val thumbnailUrl: String?,
    @JsonProperty("video_link") val videoLink: String?
)
