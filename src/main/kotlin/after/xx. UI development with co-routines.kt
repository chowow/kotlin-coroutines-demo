package after

import aBitOfTime
import kotlinx.coroutines.*
import java.util.Arrays.asList
import kotlin.system.measureTimeMillis

val defaultDispatcher = Dispatchers.Default
val mainDispatcher = newFixedThreadPoolContext(1, "Main")

fun main() = runBlocking {
    val urls = asList("www.google.com", "www.github.com", "www.tyro.com")
    for (url in urls) {
        withContext(defaultDispatcher) {
            val result = fetch(url)
            withContext(mainDispatcher) {
                println("$result on ${Thread.currentThread().name}")
            }
        }
    }
}

private suspend fun fetch(url: String): Pair<String, Long> {
    return Pair(url, measureTimeMillis {
        println("Fetching from $url on ${Thread.currentThread().name}")
        delay(aBitOfTime())
        println("Received data from $url on ${Thread.currentThread().name}")
    })
}
