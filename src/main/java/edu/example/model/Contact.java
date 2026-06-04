package edu.example.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contact {
    private String id;
    private String name;
    private String phoneNumber;
}

