package TreadPractise;

public class VolatileExample {
    private volatile boolean running = true;

    public void runTask(){
        System.out.println("Worker Thread: Starting execution . . .");
        int counter = 0;
        while (running){
            counter++;
        }
        System.out.println("Worker Thread: Detected stop signal. Final counter value: " + counter);
    }

    public void stopTask(){
        running = false;
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        Thread workerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                example.runTask();
            }
        }, "Worker Thread");
        workerThread.start();

        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("MainThread: Stopping the worker thread");
        example.stopTask();
        try {
            workerThread.join();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("MainThread: Execution finished");
    }

}
