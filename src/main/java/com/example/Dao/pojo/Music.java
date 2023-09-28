package com.example.Dao.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Music {
    private Integer id;
    private String name;
    private String path;
    private String musician;
    private String arr_img;
}
