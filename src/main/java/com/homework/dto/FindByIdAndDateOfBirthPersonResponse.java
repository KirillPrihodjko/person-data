package com.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindByIdAndDateOfBirthPersonResponse {

    private List<PersonDto> personDto;
}
