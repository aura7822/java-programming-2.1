package rev;
class Rev implements Runnable{public void run(){
    System.out.println("Thread is running...");
}public static void main(String[]args){
    Rev aura = new Rev();
    Thread joshua = new Thread(aura, "Thread execution");
    joshua.start();
    aura.run();
    System.out.println("Thread identifier : "+joshua.getName());
}
}