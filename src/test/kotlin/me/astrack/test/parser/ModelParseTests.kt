package me.astrack.test.parser

import me.astrack.module.*
import me.astrack.module.dc.Identifier
import me.astrack.module.dc.Language
import me.astrack.module.dc.Title
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

val containerExampleXml = """
<?xml version="1.0"?>
<container version="1.0" xmlns="urn:oasis:names:tc:opendocument:xmlns:container">
    <rootfiles>
        <rootfile full-path="OEBPS/My Crazy Life.opf"
            media-type="application/oebps-package+xml" />
    </rootfiles>
</container>
""".trimMargin()

val packageExampleXml = """
    <?xml version="1.0" encoding="UTF-8" ?>
    <package version="2.0" unique-identifier="MOXBID" xmlns="http://www.idpf.org/2007/opf">
      <metadata xmlns:dc="http://purl.org/dc/elements/1.1/" xmlns:opf="http://www.idpf.org/2007/opf">
        <meta name="book-type" content="comic" />
        <meta name="zero-gutter" content="true" />
        <meta name="zero-margin" content="true" />
        <meta name="RegionMagnification" content="true" />
        <meta name="fixed-layout" content="true" />
        <meta name="orientation-lock" content="portrait" />
        <meta name="original-resolution" content="1440x1920" />
        <dc:identifier id="MOXBID" opf:scheme="MOXBID">2005192510069</dc:identifier>
        <dc:title>少女終末旅行 - Vol.06</dc:title>
        <dc:language>zh-CN</dc:language>
        <dc:creator>つくみず</dc:creator>
        <dc:publisher>Mox.moe</dc:publisher>
        <dc:date>2023</dc:date>
        <dc:rights>≡ 2023 Mox.moe ≡</dc:rights>
        <dc:series>少女終末旅行</dc:series>
        <meta name="cover" content="cover_img"/>
      </metadata>
      <manifest>
        <item id="ncx" href="xml/vol.ncx" media-type="application/x-dtbncx+xml"/>

        <item id="Page_1" href="html/page-267673.html" media-type="application/xhtml+xml"/> 
        <item id="Page_2" href="html/page-235801.html" media-type="application/xhtml+xml"/> 
        <item id="Page_createby"  href="html/createby.html" media-type="application/xhtml+xml"/> 
        <item id="Page_cover"     href="html/cover.jpg.html" media-type="application/xhtml+xml"/>

        <item id="cover_img" href="image/cover.jpg" media-type="image/jpeg" properties="cover-image" />

        <item id="img_1" href="image/moe-002246.jpg" media-type="image/jpeg"/> 
        <item id="img_2" href="image/moe-006569.jpg" media-type="image/jpeg"/> 
        <item id="img_createby" href="image/createby.png" media-type="image/png"/>
        <item id="css" href="css/style.css" media-type="text/css"/>
        <item id="font01" href="misc/Courier.ttf" media-type="application/x-font-ttf"/>
      </manifest>
      <spine toc="ncx">
        <itemref idref="Page_cover" />

        <itemref idref="Page_1" /> 
        <itemref idref="Page_2" /> 
        <itemref idref="Page_createby" /> 
      </spine>
      <guide>
          <reference type="cover" href="image/cover.jpg" title="封面" />
      </guide>
    </package>
""".trimIndent()

class XmlParseTests{
    @Test
    fun containerParseTest(){
        val container = Container.parse(containerExampleXml)

        val container1 = Container(
            "1.0",
            listOf(
                RootFile("OEBPS/My Crazy Life.opf", "application/oebps-package+xml")
            )
        )
        
        assertEquals(container1, container)
    }

    @Test
    fun packageParseTest() {
        val pkg = Package.parse(packageExampleXml)

        val package1 = Package(
            "2.0",
            "MOXBID",
            null,
            null,
            null,
            null,
            Metadata(
                listOf(
                    Identifier("2005192510069")
                ),
                listOf(
                    Language("zh-CN")
                ),
                listOf(
                    Title("少女終末旅行 - Vol.06")
                ),
                listOf(
                    Meta(name =  "book-type", content =  "comic"),
                    Meta(name =  "zero-gutter", content =  "true"),
                    Meta(name =  "zero-margin", content =  "true"),
                    Meta(name =  "RegionMagnification", content =  "true"),
                    Meta(name =  "fixed-layout", content =  "true"),
                    Meta(name =  "orientation-lock", content =  "portrait"),
                    Meta(name =  "original-resolution", content =  "1440x1920")
                )
            ),
            Manifest(
                items = listOf(
                    Item("ncx", "xml/vol.ncx", "application/x-dtbncx+xml"),
                    Item("Page_1", "html/page-267673.html", "application/xhtml+xml"),
                    Item("Page_2", "html/page-235801.html", "application/xhtml+xml"),
                    Item("Page_createby", "html/createby.html", "application/xhtml+xml"),
                    Item("Page_cover", "html/cover.jpg.html", "application/xhtml+xml"),
                    Item("cover_img", "image/cover.jpg", "image/jpeg", "cover-image"),
                    Item("img_1", "image/moe-002246.jpg", "image/jpeg"),
                    Item("img_2", "image/moe-006569.jpg", "image/jpeg"),
                    Item("img_createby", "image/createby.png", "image/png"),
                    Item("css", "css/style.css", "text/css"),
                    Item("font01", "misc/Courier.ttf", "application/x-font-ttf")
                )
            ),
            Spine(
                null,
                itemrefs = listOf(
                    ItemRef("Page_cover"),
                    ItemRef("Page_1"),
                    ItemRef("Page_2"),
                    ItemRef("Page_createby")
                )
            )
        )

        assertEquals(package1, pkg)
    }
}