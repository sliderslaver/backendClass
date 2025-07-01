package com.example.Simone.mapper;

import com.example.Simone.model.CatFact;
import com.example.Simone.model.FattiSuiGatti;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CatFactToFattiSuiGatti {

    @Mapping(source = "fact", target = "fatto")
    FattiSuiGatti from(CatFact catFact);
}
