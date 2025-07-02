package com.example.Simone.mapper;

import com.example.Simone.model.CatFact;
import com.example.Simone.model.FattiSuiGatti;
import com.example.Simone.model.Toys;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ToysToToys {

    Toys from(Toys toys);
}
