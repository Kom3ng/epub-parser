package me.astrack.module

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

@JacksonXmlRootElement(localName = "meta")
data class Meta(
    @field:JacksonXmlProperty(localName = "dir", isAttribute = true) val dir: String? = null,
    @field:JacksonXmlProperty(localName = "id", isAttribute = true) val id: String? = null,
    @field:JacksonXmlProperty(localName = "property", isAttribute = true) val property: String = "",
    @field:JacksonXmlProperty(localName = "scheme", isAttribute = true) val scheme: String? = null,
    @field:JacksonXmlProperty(localName = "refines", isAttribute = true) val refines: String? = null,
    @field:JacksonXmlProperty(localName = "lang", namespace = "xml", isAttribute = true) val lang: String? = null,
    @field:JacksonXmlProperty(localName = "content", isAttribute = true) val content: String? = null,
    @field:JacksonXmlProperty(localName = "name", isAttribute = true) val name: String? = null,
    @field:JacksonXmlText val value: String? = null,
)
