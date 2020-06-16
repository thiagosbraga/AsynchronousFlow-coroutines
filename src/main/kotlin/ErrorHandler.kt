import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.Exception

fun main() {
    runBlocking {
//        tryCatch()
//        catch()
        onCompletion()
    }

}

suspend fun onCompletion(){
    (1..3).asFlow()
//            .onEach { check(it != 2) }
            .onCompletion {e ->
                if (e != null){
                    println("flow completed with exception $e")
                } else {
                    println("flow completed successfully")
                }
            }
            .catch { e -> println("Caught exception $e") }
            .collect { println(it) }
}

suspend fun catch(){
    (1..3).asFlow()
            .onEach { check(it != 2) }
            .catch { e -> println("Caught exception $e") }
            .collect { println(it) }
}

suspend fun tryCatch() {
    try {
        (1..3).asFlow()
                .onEach { check(it != 2) }
                .collect { println(it) }
    } catch (e: Exception) {
        println("Caught exception $e")
    }
}