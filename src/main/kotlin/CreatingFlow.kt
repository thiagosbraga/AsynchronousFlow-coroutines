import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        sendNumbers().collect {
            println("Receiving $it")
        }
    }
}

fun sendNumbers() = flowOf(1,2,3,4)

//        = listOf(1,2,3).asFlow()

//    flow {
//    for (i in 1..10)
//        emit(i)
//}