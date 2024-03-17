package me.astrack.module

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "manifest")
data class Manifest(
    @field:JacksonXmlElementWrapper(localName = "item", useWrapping = false)
    @field:JacksonXmlProperty(localName = "item") val items: List<Item> = listOf(),
    @field:JacksonXmlProperty(localName = "id", isAttribute = true) val id: String = "",
)
