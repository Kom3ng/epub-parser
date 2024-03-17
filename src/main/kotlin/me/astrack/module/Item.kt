package me.astrack.module

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "item")
data class Item(
    @field:JacksonXmlProperty(localName = "id", isAttribute = true) val id: String = "",
    @field:JacksonXmlProperty(localName = "href", isAttribute = true) val href: String = "",
    @field:JacksonXmlProperty(localName = "media-type", isAttribute = true) val mediaType: String = "",
    @field:JacksonXmlProperty(localName = "properties", isAttribute = true) val properties: String? = null,
    @field:JacksonXmlProperty(localName = "fallback", isAttribute = true) val fallback: String? = null,
    @field:JacksonXmlProperty(localName = "media-overlay", isAttribute = true) val mediaOverlay: String? = null,
)
