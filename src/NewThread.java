public class NewThread implements Runnable {
    Thread t;
    String name;
    public NewThread(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Child Thread: " + t);
    }

    public void run() {
        try {
            for(int i = 5; i>0; i--) {
                System.out.println("Thread " + name +" working: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupt Exception Caught in Child Thread: " + e);
        }
        System.out.println("Exiting Child Thread.");
    }
}

class DemoJoin {
    public static void main(String args[]) {
        NewThread nt1 = new NewThread("One");
        NewThread nt2 = new NewThread("two");
        NewThread nt3 = new NewThread("Three");

        nt1.t.start();
        nt2.t.start();
        nt3.t.start();

        System.out.println("Thread One is running: " + nt1.t.isAlive());

        // Thread's State
        System.out.println("Thread One State: " + nt1.t.getState());
        System.out.println("Thread Two State: " + nt2.t.getState());
        System.out.println("Thread Third State: " + nt3.t.getState());

        System.out.println("Thread Two is running: " + nt2.t.isAlive());
        System.out.println("Thread Three is running: " + nt3.t.isAlive());

        // Setting Thread Two as Max Priority
        nt2.t.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Thread two is set to Max Priority and will be processed first: " + nt2.t.getPriority());

        try {
            nt1.t.join();
            nt2.t.join();
            nt3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupt Exception is found: " + e);
        }

        System.out.println("Thread One is running: " + nt1.t.isAlive());

        // Thread's State
        System.out.println("Thread One State: " + nt1.t.getState());
        System.out.println("Thread Two State: " + nt2.t.getState());
        System.out.println("Thread Third State: " + nt3.t.getState());

        System.out.println("Thread Two is running: " + nt2.t.isAlive());
        System.out.println("Thread Three is running: " + nt3.t.isAlive());

        System.out.println("Main Thread is exiting.");
    }
}


