package com.yash.productservicejune24.inheritancetypes.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("mentor")
public class Mentor extends User{
    private int hours;
    private int noOfStudents;
}
