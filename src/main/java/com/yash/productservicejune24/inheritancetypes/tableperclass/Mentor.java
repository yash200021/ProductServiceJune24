package com.yash.productservicejune24.inheritancetypes.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_mentor")
public class Mentor extends User{
    private int hours;
    private int noOfStudents;
}
