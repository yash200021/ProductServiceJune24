package com.yash.productservicejune24.inheritancetypes.joinedtables;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_student")
public class Student extends User{
    private double psp;
    private double fee;
}
