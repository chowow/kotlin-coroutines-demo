package after

import aBitOfTime
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// start without runBlocking
fun main() = runBlocking {
    val urls = arrayOf("www.google.com", "www.github.com", "www.tyro.com")
    urls.forEach {
        // start without async
        async { println(fetch(it)) }
    }
}

// start without suspend
private suspend fun fetch(url: String): Pair<String, Long> {
    return Pair(url, measureTimeMillis {
        println("Fetching from $url on ${Thread.currentThread().name}")
        delay(aBitOfTime())
        println("Received data from $url on ${Thread.currentThread().name}")
    })
}