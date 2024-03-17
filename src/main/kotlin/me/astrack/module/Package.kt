package me.astrack.module

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "package")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Package (
    @field:JacksonXmlProperty(localName = "version", isAttribute = true) val version:String = "3.0",
    @field:JacksonXmlProperty(localName = "unique-identifier", isAttribute = true) val uniqueIdentifier: String = "uuid",
    @field:JacksonXmlProperty(localName = "xmlns", isAttribute = true) val xmlns: String? = null,
    @field:JacksonXmlProperty(localName = "prefix", isAttribute = true) val prefix: String? = null,
    @field:JacksonXmlProperty(localName = "lang", namespace = "xml", isAttribute = true) val xmlLang: String? = null,
    @field:JacksonXmlProperty(localName = "dir", isAttribute = true,) val dir: String? = null,

    @field:JacksonXmlProperty(localName = "metadata") val metadata: Metadata = Metadata(),
    @field:JacksonXmlProperty(localName = "manifest") val manifest: Manifest = Manifest(),
    @field:JacksonXmlProperty(localName = "spine") val spine: Spine = Spine(),
    @field:JacksonXmlElementWrapper(localName = "collection") val collections: List<Collection> = listOf(),
) {
    companion object {
        fun parse(xml: String): Package {
            return XmlMapper().readValue(xml, Package::class.java)
        }
    }
}