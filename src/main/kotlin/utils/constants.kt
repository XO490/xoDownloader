package utils

import models.Details
import models.Urls
import utils.os.getOS

const val APPNAME: String = "xoDownloader"
const val VERSION: String = "2.0.3"

const val useragent: String =
    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36 Vivaldi/5.5.2805.35"

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
 * 3 = Aquamarine (Cyan)
 * 4 = Red
 * 5 = Violet
 * 6 = Yellow
 * 7 = White
 * 8 = Gray
 * 9 = Light-Blue
 * A = Light-Green
 * В = Light-Aquamarine (Cyan)
 * С = Light-Red
 * D = Light-Violet
 * E = Light-Yellow
 * F = Bright-white
 * */

var ANSI_RESET: String = ""
var ANSI_RED: String = ""
var ANSI_GREEN: String = ""
var ANSI_YELLOW: String = ""
var ANSI_BLUE: String? = null
var ANSI_PURPLE: String = ""
var ANSI_CYAN : String = ""
//const val ANSI_BLACK = "\u001B[30m"
//const val ANSI_WHITE = "\u001B[37m"

fun getColors() {
    when (getOS()) {
        OS.LINUX -> {
            ANSI_RESET = "\u001B[0m"
            ANSI_RED = "\u001B[31m"
            ANSI_GREEN = "\u001B[32m"
            ANSI_YELLOW = "\u001B[33m"
            ANSI_BLUE = "\u001B[34m"
            ANSI_PURPLE = "\u001B[35m"
            ANSI_CYAN = "\u001B[36m"
        }
        OS.WINDOWS -> {
            ANSI_RESET = "color 07"
            ANSI_RED = "color 04"
            ANSI_GREEN = "color 02"
            ANSI_YELLOW = "color 06"
            ANSI_BLUE = "color 01"
            ANSI_PURPLE = "color 05"
            ANSI_CYAN = "color 03"
        }

        else -> {}
    }
}

fun msgAppVer(): String {
    getColors()
    return "\n$ANSI_CYAN··◌◌ $APPNAME ${ANSI_BLUE}v$VERSION $ANSI_CYAN◌◌··$ANSI_RESET"
}

//val MSG_APP_VER = "$ANSI_CYAN··◌◌ $APPNAME ${ANSI_BLUE}v$VERSION $ANSI_CYAN◌◌··$ANSI_RESET"
val MSG_START = "$ANSI_YELLOW------------------\n  Start parsing\n------------------$ANSI_RESET"
val MSG_DOWNLOAD = "$ANSI_YELLOW------------------\n  Download now..\n------------------$ANSI_RESET"
val MSG_FINAL = "$ANSI_PURPLE------------------\n  All Well Done\n------------------$ANSI_RESET"


val projectDetails = ArrayList<Details>()
val downloadUrls = ArrayList<Urls>()

