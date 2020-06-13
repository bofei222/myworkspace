package com.bf.xmlparse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    String name;
    String author;
    String price;
    int age;
    String title;
}
