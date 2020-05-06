public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    //create instances
    private static ChocolateBoiler instance;
    private static Object mutex = new Object();
    
    
    public static ChocolateBoiler getInstance() {
        ChocolateBoiler result = instance; //creates result as instance in that moment
        if (result == null) { //if null, create unique instance of chocolate boiler
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = result = new ChocolateBoiler();
                    System.out.println("Thread enviado");
                }
            }
        } else {
            System.out.println("Thread came back gaaaa");
        }
        return result;
    }
    
    public ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public void fill(){
        if(isEmpty()){
            empty = false;
            boiled = false;
        }
    }

    public void drain(){
        if(isEmpty() && isBoiled()){
            //drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil(){
        if(!isEmpty() && isBoiled()){
            //bring the contents to a boil
            boiled = true;
        }
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }
}
