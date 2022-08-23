package com.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Long gender;
    private String dateOfBirth;
}