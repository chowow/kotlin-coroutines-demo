
fun sleep(timeToSleepMs: Long) {
    try {
        Thread.sleep(timeToSleepMs)
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }

}

fun aBitOfTime() = (1000L..3000L).shuffled().first()

