package before

import aBitOfTime
import sleep
import java.util.Arrays.asList
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

// Remove thread pool
// Make suspend
// Add runBlocking
// Run?
// Add async
// Run
// Change sleep to delay
fun main() {
    val threadPool = Executors.newFixedThreadPool(3)
    val urls = asList("www.google.com", "www.github.com", "www.tyro.com")
    for (url in urls) {
        threadPool.submit { println(fetch(url)) }
    }
    threadPool.shutdown()
}

private fun fetch(url: String): Pair<String, Long> {
    return Pair(url, measureTimeMillis {
        println("Fetching from $url on ${Thread.currentThread().name}")
        sleep(aBitOfTime())
        println("Received data from $url on ${Thread.currentThread().name}")
    })
}