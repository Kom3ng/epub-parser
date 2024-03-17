package me.astrack.module

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "itemref")
data class ItemRef(
    @field:JacksonXmlProperty(localName = "idref", isAttribute = true) val idref: String,
    @field:JacksonXmlProperty(localName = "id", isAttribute = true) val id: String? = null,
    @field:JacksonXmlProperty(localName = "linear", isAttribute = true) val linear: String? = null,
    @field:JacksonXmlProperty(localName = "properties", isAttribute = true) val properties: String? = null,
)
