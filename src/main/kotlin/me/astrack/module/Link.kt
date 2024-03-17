package me.astrack.module

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "link")
data class Link(
    @field:JacksonXmlProperty(localName = "href", isAttribute = true) val href: String,
    @field:JacksonXmlProperty(localName = "hreflang", isAttribute = true) val hreflang: String? = null,
    @field:JacksonXmlProperty(localName = "rel", isAttribute = true) val rel: String,
    @field:JacksonXmlProperty(localName = "media-type", isAttribute = true) val mediaType: String? = null,
    @field:JacksonXmlProperty(localName = "id", isAttribute = true) val id: String? = null,
    @field:JacksonXmlProperty(localName = "refines", isAttribute = true) val refines: String? = null,

)
