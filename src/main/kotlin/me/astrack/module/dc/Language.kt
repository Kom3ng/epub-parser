package me.astrack.module.dc

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

@JacksonXmlRootElement(localName = "language", namespace = "dc")
data class Language(
    @field:JacksonXmlText val value: String = "",
    @field:JacksonXmlProperty(localName = "id", isAttribute = true) val id: String? = null,
)
