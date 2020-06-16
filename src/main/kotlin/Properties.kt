import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        val numberFlow = sendNumber()
        println("Flow hanst started yet")
        println("Starting flow now")

        withTimeoutOrNull(1000L){
            numberFlow.collect{ println(it) }
        }


    }

}
fun sendNumber() = flow {
    listOf(1,2,3).forEach {
        delay(400L)
        emit(it)

    }
}