package com.ingressaca.bookstoretask.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AppUserDTO  extends BaseDTO {

    private String username;

    private Set<RoleDTO> roles;
}
