import kotlinx.coroutines.*

/*

Globalscope launches the coroutine in a new thread
GlobalScope will stop only when the application is destroyed


GlobalScope.launch(Dispatchers.Main) {  Only for android
    //used for UI updates
}
GlobalScope.launch(Dispatchers.IO) {
    //used for Network calls / Disk operations
}
GlobalScope.launch(Dispatchers.Default) {
    //used for long running operations / CPU intensive task
}
GlobalScope.launch(Dispatchers.Unconfined) {
    //used when you don't want it to be confined to specific thread
}
GlobalScope.launch(newSingleThreadContext("myThread")) {
    //used when you want it to run on your thread
}

*/

class DispatcherTest {

    fun run() {
        GlobalScope.launch(newSingleThreadContext("New Thread")) {
            //used when you want it to run on your thread
            println("GlobalScope New Thread :  ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.IO) {
            //used for Network calls
            println("GlobalScope IO 1 :  ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.IO) {
            //used for Network calls
            println("GlobalScope IO 2 :  ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.IO) {
            //used for Network calls
            println("GlobalScope IO 3 :  ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Default) {
            //used for long running operations
            println("GlobalScope Default 1 :  ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Default) {
            //used for long running operations
            println("GlobalScope Default 2 :  ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Default) {
            //used for long running operations
            println("GlobalScope Default 3 :  ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Unconfined) {
            //used when you don't want it to be confined to specific thread
            println("GlobalScope Unconfined 1 :  ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Unconfined) {
            //used when you don't want it to be confined to specific thread
            println("GlobalScope Unconfined 2 :  ${Thread.currentThread().name}")
        }

        GlobalScope.launch {
            //used when you don't want it to be confined to specific thread
            println("GlobalScope launch 1 :  ${Thread.currentThread().name}")
        }

        GlobalScope.launch {
            //used when you don't want it to be confined to specific thread
            println("GlobalScope launch 2 :  ${Thread.currentThread().name}")
        }

        GlobalScope.launch {
            //used when you don't want it to be confined to specific thread
            println("GlobalScope launch 3 :  ${Thread.currentThread().name}")
        }



        runBlocking {
            delay(2000L)  // Delay pauses coroutine but Thread still running
            println("runBlocking :  ${Thread.currentThread().name}")
        }

        println("MainUI :  ${Thread.currentThread().name}")
    }
}