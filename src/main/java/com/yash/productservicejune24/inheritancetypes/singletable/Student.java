package com.yash.productservicejune24.inheritancetypes.singletable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("student")
public class Student extends User{
    private double psp;
    private double fee;
}
