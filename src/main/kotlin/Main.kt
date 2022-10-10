import domains.startParsing
import io.ktor.client.statement.*
import utils.*
import utils.filesystem.saveWebContext
import utils.os.getOS
import utils.web.ktorClient


suspend fun downloadContent() {
    println(MSG_DOWNLOAD)
    downloadUrls.forEach { item ->
        if (item.url?.let { ktorClient(it).status.toString() } == "200 OK") {
            saveWebContext(
                data = ktorClient(item.url).readBytes(),
                path = projectDetails[0].path,
                filename = projectDetails[0].path + item.filename
            )
        } else {
            println("${ANSI_RED}upss | $item$ANSI_RESET")
        }
    }
    println(MSG_FINAL)
}


suspend fun main(args: Array<String>) {
    println("\n$MSG_APP_VER")
    val param = getArgs(args = args)
    if (param["status"] != "") {
        startParsing(albumUrl = param["parsUrl"]!!)
        downloadContent()
    }
}
