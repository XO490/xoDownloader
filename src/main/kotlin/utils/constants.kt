package utils

import models.Details
import models.Urls

const val APPNAME: String = "xoDownloader"
const val VERSION: String = "2.0.2"

const val useragent: String =
    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.93 Safari/537.36"

enum class OS {
    LINUX, WINDOWS
}

/**
 * ANSI Colors for messages in terminal | LINUX
 *
 * ANSI Colors Windows terminal
 * 0 = Black
 * 1 = Blue
 * 2 = Green
 * 3 = Аквамарин
 * 4 = Красный
 * 5 = Фиолетовый
 * 6 = Желтый
 * 7 = Белый
 * 8 = Серый
 * 9 = Светло-голубой
 * A = Светло-зеленый
 * В = Светлый аквамарин
 * С = Светло-красный
 * D = Светло-фиолетовый
 * E = Светло-желтый
 * F = Ярко-белый
 * */

const val ANSI_RESET = "\u001B[0m"
//const val ANSI_BLACK = "\u001B[30m"
const val ANSI_RED = "\u001B[31m"
const val ANSI_GREEN = "\u001B[32m"
const val ANSI_YELLOW = "\u001B[33m"
const val ANSI_BLUE = "\u001B[34m"
const val ANSI_PURPLE = "\u001B[35m"
const val ANSI_CYAN = "\u001B[36m"
//const val ANSI_WHITE = "\u001B[37m"

const val MSG_APP_VER = "$ANSI_CYAN··◌◌ $APPNAME ${ANSI_BLUE}v$VERSION $ANSI_CYAN◌◌··$ANSI_RESET"
const val MSG_START = "$ANSI_YELLOW------------------\n  Start parsing\n------------------$ANSI_RESET"
const val MSG_DOWNLOAD = "$ANSI_YELLOW------------------\n  Download now..\n------------------$ANSI_RESET"
const val MSG_FINAL = "$ANSI_PURPLE------------------\n  All Well Done\n------------------$ANSI_RESET"


val projectDetails = ArrayList<Details>()
val downloadUrls = ArrayList<Urls>()
