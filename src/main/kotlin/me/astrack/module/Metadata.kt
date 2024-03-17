package me.astrack.module

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import me.astrack.module.dc.Identifier
import me.astrack.module.dc.Language
import me.astrack.module.dc.Title

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "metadata")
data class Metadata(
    @field:JacksonXmlElementWrapper(useWrapping = false) val identifier: List<Identifier> = listOf(),
    @field:JacksonXmlElementWrapper(useWrapping = false) val language: List<Language> = listOf(),
    @field:JacksonXmlElementWrapper(useWrapping = false) val title: List<Title> = listOf(),
    @field:JacksonXmlElementWrapper(useWrapping = false) val meta: List<Meta> = listOf(),
)