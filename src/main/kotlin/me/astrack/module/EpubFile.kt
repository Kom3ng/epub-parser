package me.astrack.module

import java.io.File
import java.util.zip.ZipFile

class EpubFile(file: File) {
    var container: Container
    var books: MutableList<Book> = mutableListOf()
    init {
        ZipFile(file).use { zip ->
            container = Container.parse(zip.getInputStream(zip.getEntry("META-INF/container.xml")).reader().readText())
            container.rootFiles.forEach { rootFile ->
                zip.getInputStream(zip.getEntry(rootFile.fullPath)).reader().use { reader ->
                    val pkg = Package.parse(reader.readText())
                    books.add(Book(pkg))
                }
            }
        }
    }
}