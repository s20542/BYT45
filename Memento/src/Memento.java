public class Memento {
    private int size;
    private String name;

    public Memento(int size, String name){
        this.size = size;
        this.name = name;
    }

    public int getSize(){
        return size;
    }

    public String getName(){
        return name;
    }
}
