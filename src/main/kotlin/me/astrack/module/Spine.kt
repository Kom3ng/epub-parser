package me.astrack.module

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "spine")
data class Spine (
    @field:JacksonXmlProperty(localName = "id", isAttribute = true) val id: String? = null,
    @field:JacksonXmlProperty(localName = "page-progression-direction", isAttribute = true) val pageProgressionDirection: String? = null,
    @field:JacksonXmlElementWrapper(localName = "itemref") val itemrefs: List<ItemRef> = listOf(),
)