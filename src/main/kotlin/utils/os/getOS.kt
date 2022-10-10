package utils.os

import io.ktor.util.*
import utils.OS

fun getOS(): OS? {
    val os = System.getProperty("os.name").toLowerCasePreservingASCIIRules()

    return when{
        os.contains("win") -> {
            OS.WINDOWS
        }
        os.contains("lin") || os.contains("nix") -> {
            OS.LINUX
        }
        else -> null
    }
}