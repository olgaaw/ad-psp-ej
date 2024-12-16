package com.salesianostriana.monumentosv2.dto;

import com.salesianostriana.monumentosv2.model.Monumento;

import java.util.List;

public record GetMonumentoListDto (
        Long count,
        List<Monumento> monumentos


) {
    public static GetMonumentoListDto of (List<Monumento> monumentos) {
        return new GetMonumentoListDto(
                (long) monumentos.size(),
                monumentos
        );

    }

    public List<Monumento> to() {
        return monumentos;
    }



}
