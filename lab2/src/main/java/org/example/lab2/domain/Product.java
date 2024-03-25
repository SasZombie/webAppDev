package org.example.lab2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
    public enum cathegory{
        Cheap(1), Old(2), Newer(3);


        private final int value;

        cathegory(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    private Long id;
    private String name;
    private Long price;
    private cathegory category;
}
