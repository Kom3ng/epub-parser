package me.astrack.module.dc

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

@JacksonXmlRootElement(localName = "title", namespace = "dc")
data class Title(
    @field:JacksonXmlText val value: String = "",
    @field:JacksonXmlProperty(localName = "id", isAttribute = true) val id: String? = null,
    @field:JacksonXmlProperty(localName = "lang", namespace = "xml", isAttribute = true) val lang: String? = null,
    @field:JacksonXmlProperty(localName = "dir", isAttribute = true) val dir: String? = null,
)
