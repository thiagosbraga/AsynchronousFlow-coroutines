import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
//        zip()
        combine()
    }
}

suspend fun combine(){
    val number = (1..5).asFlow().onEach { delay(900L) }
    val values = flowOf("one", "two","three","four","five").onEach { delay(100L) }
    number.combine(values){a: Int, b: String -> "$a -> $b" }
            .collect {
                println(it)
            }
}
suspend fun zip() {
    val english = flowOf("one", "two", "three")
    val french = flowOf("un", "deux", "troix")

    english.zip(french) { a: String, b: String -> "$a is a $b" }
            .collect {
                println(it)
            }
}