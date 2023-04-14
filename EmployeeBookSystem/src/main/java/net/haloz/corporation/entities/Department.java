package net.haloz.corporation.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Department {
    DEPARTMENT_1(1), DEPARTMENT_2(2), DEPARTMENT_3(3), DEPARTMENT_4(4), DEPARTMENT_5(5);

    private final int id;
}
