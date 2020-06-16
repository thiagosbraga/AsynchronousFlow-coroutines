import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {

        println("Receiving prime number")
        sendPrimes().collect {
            println("Received prime nummber $it")
        }
        println("Finished received")
    }
}


fun sendPrimes(): Flow<Int> = flow {
    val primelist = listOf(12,3,5,7,11,13,17,19,23,29)
    primelist.forEach {
        delay(it*100L)
        emit(it)
    }

}