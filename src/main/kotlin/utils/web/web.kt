package utils.web

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

fun getHtml(url: String, useragent: String): Document? {
    return Jsoup.connect(url).userAgent(useragent).get()
}

suspend fun ktorClient(url: String): HttpResponse {
    val client = HttpClient(CIO) {
        Charsets {
            register(charset("utf8"))
        }
    }
    return client.get(url)
}