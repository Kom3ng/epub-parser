package me.astrack.module

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "container")
data class Container (
    @field:JacksonXmlProperty(localName = "version", isAttribute = true) val version:String = "1.0",
    @field:JacksonXmlElementWrapper(localName = "rootfiles")
    @field:JacksonXmlProperty(localName = "rootfile")
    val rootFiles: List<RootFile> = listOf()
) {
    companion object {
        fun parse(xml: String): Container {
            return XmlMapper().readValue(xml, Container::class.java)
        }
    }
}