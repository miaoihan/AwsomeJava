package pojo;

import java.lang.Iterable;

/**
 * time: 16-5-12.
 * author: han
 */
public abstract class Person implements Iterator {
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
}
