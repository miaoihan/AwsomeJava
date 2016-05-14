package pojo;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * time: 16-5-12.
 * author: han
 */
public class Person implements Iterable {
    public String name;
    public Integer id;
    //定义接力指向下一个
    public Person next = null;

    public boolean hasNext(){
        return next != null;
    }

    public Person(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
