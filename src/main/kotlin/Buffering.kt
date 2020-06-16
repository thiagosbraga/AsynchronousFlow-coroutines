import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time = measureTimeMillis {

            generate()
                    .buffer()
                    .collect {
                        delay(100L)
                        println(it)
                    }
        }
        println("collected in $time ms" )
    }

}

fun generate() = flow {
    for (i in 1..3) {
        delay(300L)
        emit(i)
    }

}