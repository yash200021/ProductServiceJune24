package com.yash.productservicejune24.inheritancetypes.joinedtables;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentor")
public class Mentor extends User{
    private int hours;
    private int noOfStudents;
}
