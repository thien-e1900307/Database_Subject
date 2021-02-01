package fi.vamk.e1900307.Spring_Boot_Homework;

import javax.persistence.Entity;
import javax.persistence.interface;


@Entity
public class Information {
    
    @interface
    private int id;
    private String name;
    private String email;
    private String phone;
    private int profile; 
}
