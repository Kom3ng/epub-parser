package me.astrack.module

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "collection")
data class Collection(
    @field:JacksonXmlProperty(localName = "dir", isAttribute = true) val dir: String? = null,
    @field:JacksonXmlProperty(localName = "id", isAttribute = true) val id: String? = null,
    @field:JacksonXmlProperty(localName = "role", isAttribute = true) val role: String,
    @field:JacksonXmlProperty(localName = "lang", namespace = "xml", isAttribute = true) val lang: String? = null,
    @field:JacksonXmlElementWrapper(localName = "metadata") val metadata: List<Metadata> = listOf(),
    @field:JacksonXmlElementWrapper(localName = "collection", useWrapping = false)
    @field:JacksonXmlProperty(localName = "collection")
    val collections: List<Collection> = listOf(),
    @field:JacksonXmlElementWrapper(localName = "link") val links: List<Link> = listOf(),
)
