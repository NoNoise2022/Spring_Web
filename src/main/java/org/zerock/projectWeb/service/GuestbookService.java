package org.zerock.projectWeb.service;

import org.springframework.data.domain.Page;
import org.zerock.projectWeb.dto.GuestbookDTO;
import org.zerock.projectWeb.dto.PageRequestDTO;
import org.zerock.projectWeb.dto.PageResultDTO;
import org.zerock.projectWeb.entity.Guestbook;

import java.util.function.Function;

public interface GuestbookService {
    Long register(GuestbookDTO dto);
    PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO resultDTO);



    GuestbookDTO read(Long gno);
    void modify(GuestbookDTO dto);
    void remove(Long gno);


    default Guestbook dtoToEntity(GuestbookDTO dto) {
        Guestbook entity = Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    /**
     * Converts a Guestbook entity to a GuestbookDTO.
     *
     * @param entity the Guestbook entity
     * @return the converted GuestbookDTO
     */
    default GuestbookDTO entityToDto(Guestbook entity) {
        return GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
    }


}
