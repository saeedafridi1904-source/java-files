import java.util.concurrent.Semaphore;

class DiningPhilosophers {
    
    // A global lock allowing only 1 philosopher to pick up forks and eat at a time
    private final Semaphore globalLock;

    public DiningPhilosophers() {
        this.globalLock = new Semaphore(1);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        // Acquire the global lock before doing any fork operations
        globalLock.acquire();
        
        // Consecutively execute the operations for the current philosopher
        pickLeftFork.run();
        pickRightFork.run();
        
        eat.run();
        
        putLeftFork.run();
        putRightFork.run();
        
        // Release the global lock so the next philosopher thread can proceed
        globalLock.release();
    }
}