package domains

import models.Details
import models.Urls
import org.jsoup.nodes.Document
import utils.MSG_START
import utils.downloadUrls
import utils.filesystem.saveHtmlFile
import utils.projectDetails
import utils.useragent
import utils.web.getHtml


fun startParsing(albumUrl: String) {
    println(MSG_START)

    val baseUrl = "https://" + albumUrl.replace("https://", "").split("/").first()

    val html: Document? = getHtml(albumUrl, useragent)
    saveHtmlFile(html = html)

    val header: String? = html?.select("header.content__title")?.text()
    val artist = header?.split("-")?.get(0)?.trim()
    val album = header?.split("-")?.get(1)?.split("(")?.get(0)?.trim()
    val year = header?.split("(")?.get(1)?.replace(")", "")

    val tags: String? = html?.select("p.genre__labels")?.get(0)?.text()
        ?.replace("#", " | ")
        ?.replaceFirst(" | ", "")

    val imgUrl: String? = html?.select("img.album-img")?.attr("data-src")
    val tracks = html?.select("div.playlist")?.select("div.playlist__item")

    println("Project: $header\n" +
            "Genres: $tags\n" +
            "Cover: $imgUrl\n" +
            "Tracks: ${tracks?.count()}\n")

    val path = "$artist/$year - $album/"

    projectDetails.add(Details(baseUrl, tags, path))
    downloadUrls.add(Urls(
        url = imgUrl,
        filename = imgUrl?.split("/")!!.last()))

    tracks?.forEach { e ->
        val trackPosition = e?.select("div.playlist__position")?.text()
        val trackName = e?.select("div.playlist__heading")?.text()
        val trackUrl = e?.select("div.playlist__actions")?.select("a")?.attr("href")
        println("$trackPosition $trackName")
        val filename = "${trackPosition}_${trackName
            ?.replace(" ","_")?.lowercase()}" +
                ".${trackUrl?.split(".")?.last()}"
        downloadUrls.add(Urls(
            "$baseUrl$trackUrl",
            filename = filename))
    }
}