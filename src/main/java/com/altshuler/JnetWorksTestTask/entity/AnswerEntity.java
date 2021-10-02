package com.altshuler.JnetWorksTestTask.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerEntity {
    private String original;
    private String reduced;
}
