package me.astrack.module

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "rootfile")
data class RootFile (
    @field:JacksonXmlProperty(localName = "full-path", isAttribute = true) val fullPath: String = "",
    @field:JacksonXmlProperty(localName = "media-type", isAttribute = true) val mediaType: String = ""
)