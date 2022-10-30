package de.griefed.tests

import com.fasterxml.jackson.databind.ObjectMapper
import net.lingala.zip4j.ZipFile
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.io.File
import java.net.URL
import java.nio.file.Paths
import java.util.jar.JarFile

@SpringBootApplication
class Main

fun main(args: Array<String>) {
    println("Regular Class in Jar")
    println(SomeClass().javaClass.source(true))

    println()
    println("Class in Jar in Jar")
    val nested = ObjectMapper().javaClass.source(false)
    println(nested)

    if (ObjectMapper().javaClass.isNested()) {
        println("Nested: $nested")
        val inner = nested.toString().substring(nested.toString().lastIndexOf("!"))
        println("Inner $inner")
        val nestedJar = File(inner.substring(2))
        ZipFile(nested.toString().replace(inner,"")).extractFile(nestedJar.toString(),System.getProperty("java.io.tmpdir"),nestedJar.name)
        val extract = File(System.getProperty("java.io.tmpdir"),nestedJar.name)
        extract.deleteOnExit()
        ZipFile(extract).fileHeaders.forEach { println(it) }

    }
    println("Done")
}

private val jar = "^jar:(file:.*[.]jar)!/.*".toRegex()
private val jarJar = "^(file:.*[.]jar)!.*[.]jar".toRegex()
private val nested = ".*[.]jar!.*[.]jar".toRegex()

fun <T: Any> Class<T>.isNested(): Boolean {
    return this.source(false).toString().matches(nested)
}

fun <T : Any> Class<T>.source(rootOnly: Boolean): File {
    val classResource: URL = this.getResource(this.simpleName + ".class")
        ?: throw RuntimeException("class resource is null")
    val url = classResource.toString()
    if (url.startsWith("jar:file:")) {
        var path = url.replace(jar, "$1")
        if (rootOnly && path.matches(jarJar)) {
            path = path.replace(jarJar,"$1")
        }
        return try {
            Paths.get(URL(path).toURI()).toFile()
        } catch (e: Exception) {
            throw RuntimeException("Invalid Jar File URL String")
        }
    } else if (url.startsWith("file:")) {
        return try {
            Paths.get(URL(url).toURI()).toFile().parentFile
        } catch (e: Exception) {
            throw RuntimeException("Invalid Jar File URL String")
        }
    }
    throw RuntimeException("Invalid Jar File URL String")
}

fun JarFile.contents(): List<String> {
    val entries = ArrayList<String>()
    val enumerations = this.entries()
    while(enumerations.hasMoreElements()) {
        entries.add(enumerations.nextElement().name)
    }
    return entries
}