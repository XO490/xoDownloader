package utils.filesystem

import utils.ANSI_GREEN
import utils.ANSI_RED
import utils.ANSI_RESET
import java.io.File
import java.io.IOError
import java.nio.file.Files


fun saveHtmlFile(filename: String = "page.html", html: Any?) {
    if (html != null) {
        val file = File(filename)
        val data = html.toString()
        file.createNewFile()
        try {
            Files.write(file.toPath(), data.toByteArray(charset("utf8")))
            println(ANSI_GREEN + "DONE | html document saved to $filename" + ANSI_RESET)
        } catch (err: IOError) {
            error(err)
        }
    } else {
        println("$ANSI_RED[err]>saveHtmlFile: html data is EMPTY!$ANSI_RESET")
    }
}


fun saveWebContext(data: ByteArray, path: String, filename: String) {
    File(path).mkdirs()
    val file = File(filename)
    file.writeBytes(data)
    println(ANSI_GREEN + "DONE | $filename saved" + ANSI_RESET)
}
