package com.yash.productservicejune24.inheritancetypes.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("instructor")
public class Instructor extends User{
    private double salary;
    private double rating;
}
