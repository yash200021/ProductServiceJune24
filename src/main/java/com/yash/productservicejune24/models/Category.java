package com.yash.productservicejune24.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category extends BaseModel{
    private String name;
    private String description;
}
