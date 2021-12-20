package br.com.contact;

import lombok.Data;

@Data
public class ContactRequest {

    private String name;
    private String email;
    private String phone;
}
