package after

import aBitOfTime
import kotlinx.coroutines.*
import sleep
import java.util.Arrays.asList
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val urls = asList("www.google.com", "www.github.com", "www.tyro.com")
    for (url in urls) {
        async { println(fetch(url)) }
    }
}

private suspend fun fetch(url: String): Pair<String, Long> {
    return Pair(url, measureTimeMillis {
        println("Fetching from $url on ${Thread.currentThread().name}")
        delay(aBitOfTime())
        println("Received data from $url on ${Thread.currentThread().name}")
    })
}