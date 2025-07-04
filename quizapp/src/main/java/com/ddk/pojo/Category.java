package com.ddk.pojo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//@AllArgsConstructor
public class Category {
    private int id;
    private String name;

    @Override
    public String toString() {
        return this.name;
    }
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
  
}
