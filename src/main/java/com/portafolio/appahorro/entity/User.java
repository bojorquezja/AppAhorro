package com.portafolio.appahorro.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @NonNull
    private String userName;


    @NotNull
    @NonNull
    private String password;


    private boolean active = true;


    @NonNull
    private String roles;


    @NonNull
    private String permissions;

    //faltan lista de roles y permisos
    public List<String> getRoleList(){
        return roles.length() > 0 ? Arrays.stream(roles.split(",")).toList() : new ArrayList<String>();
    }
    public List<String> getPermisionList(){
        return permissions.length() > 0 ? Arrays.stream(permissions.split(",")).toList() : new ArrayList<String>();
    }
}
