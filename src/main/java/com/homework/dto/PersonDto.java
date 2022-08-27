package com.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
}
