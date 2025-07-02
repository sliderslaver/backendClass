package com.example.Simone.mapper;

import com.example.Simone.model.*;
import com.example.Simone.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", imports = {UserService.class})
public interface AllToGarbageDTO {

    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "user.age", target = "eta")
    @Mapping(source = "catFact.fact", target = "fattoSulProprioGatto")
    @Mapping(target = "nome", expression = "java(UserService.randomString(username))")
    GarbageDTO from(String username, User user, CatFact catFact);
}
