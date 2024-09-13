package com.ecommerce.ecommproductservice.DTO;


import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String name;
    private String email;
    private List<Role> roles;

}
