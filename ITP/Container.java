package de.tum.cit.ase;

//TODO 1.1 Modify the class to use a generic type
public class Container <T extends Comparable<T>> {
    private int count;
    private T content;
    //TODO 1.1 Add the `content` attribute and initialize it in the constructor

    public Container(int count, T content) {
        this.count = count;
        this.content = content;
    }

    //TODO 1.1 Add getter & setter for the new attribute

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getContent() {return content;}

    public void setContent(T content){ this.content = content;}
}
