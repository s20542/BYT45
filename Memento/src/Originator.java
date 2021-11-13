public class Originator {
    private int size;
    private String name;

    public void setSize(int size){
        this.size = size;
    }

    public int getSize (){
        return size;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Memento saveWorld(){
        return new Memento(size, name);
    }

    public void getWorldInfoFromMemento (Memento memento){
        size = memento.getSize();
        name = memento.getName();
    }
}
