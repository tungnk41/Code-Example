import kotlinx.coroutines.*

/*
* For android :
 + lifecycleScope coroutine is destroyed when activity is destroyed,
 in android app, dont use GlobleScope because it can cause memory leak, GlobleScope is destroyed when App exit
 *
    lifecycleScope.launch {
        doSomething()
    }

    in ViewModel :
    viewModelScope.launch {
        doSomething()
    }

*
*
*
* */

fun main(args: Array<String>) {

    val dispatcherTest = DispatcherTest()

    //dispatcherTest.run()


    val job = GlobalScope.launch(Dispatchers.IO){
        val response = doNetworkCall()
        withContext(Dispatchers.Default){
            repeat(5){
                if(isActive){

                }
                println("Response : $response")
            }

        }
    }



    GlobalScope.launch(Dispatchers.IO){
        val job_1 = async{
            doDiskOpt()
            doNetworkCall() //only lastest function return is used for result of async - await

        }
        val job_2 = async{
            doNetworkCall()
        }
        job_1.join()
        job_2.join()

        println(job_1.await() + " " + job_2.await())
    }


    runBlocking {
        //job.join() // Block current thread because it waits coroutine done before execute below code
        delay(3000L)
        job.cancel()
        launch(Dispatchers.Default) {
            println("Task 1 ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) {
            println("Task 2 ${Thread.currentThread().name}")
        }

        delay(1000L) //RunBlocking delay the entire thread instead of just the coroutine
    }

}

suspend fun doNetworkCall() : String{
    delay(1000L)
    println("Network call")
    return "Data"
}

suspend fun doDiskOpt() : String{
    delay(1000L)
    println("Read/Write Disk")
    return "Disk"
}