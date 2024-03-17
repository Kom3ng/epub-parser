package me.astrack.module.dc

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "identifier", namespace = "dc")
data class Identifier(
    @field:JacksonXmlText val value: String? = null
)
