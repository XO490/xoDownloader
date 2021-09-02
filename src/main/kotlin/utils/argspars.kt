package utils


fun getArgs(args: Array<String>): Map<String, String> {
    val help = "-h\tthis help\n" +
            "-v\tversion\n" +
            "-u\turl for pars and downloads album (example: -u=https://musify.club/release/mujuice-amore-e-morte-2016-699092)\n"

    if (args.isNotEmpty()) {
        for (arg in args) {
            when {
                arg.startsWith("-h") -> println(help)
                arg.startsWith("-v") -> println(VERSION)
                arg.startsWith("-u") -> {
                    val parsUrl = arg.split("-u=")[1]
                    return mapOf(
                        "parsUrl" to parsUrl)
                }
            }
        }
    } else println(help)
    return mapOf("status" to "")
}