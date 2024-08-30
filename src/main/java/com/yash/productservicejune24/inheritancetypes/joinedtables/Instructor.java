package com.yash.productservicejune24.inheritancetypes.joinedtables;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_instructor")
public class Instructor extends User{
    private double salary;
    private double rating;
}
