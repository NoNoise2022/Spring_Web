package org.zerock.projectWeb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.projectWeb.dto.GuestbookDTO;

import org.zerock.projectWeb.dto.PageRequestDTO;
import org.zerock.projectWeb.dto.PageResultDTO;
import org.zerock.projectWeb.entity.Guestbook;

@SpringBootTest
public class GuestbookServiceTests {


    @Autowired
    GuestbookService service;

    @Test
    public void testRegister() {

        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title...")
                .content("Sample Content...")
                .writer("user0")
                .build();

        System.out.println(service.register(guestbookDTO));

    }

    @Test
    public void testList(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

//        System.out.println("PREV: "+resultDTO.isPrev());
//        System.out.println("NEXT: "+resultDTO.isNext());
//        System.out.println("TOTAL: " + resultDTO.getTotalPage());
//        System.out.println("-------------------------------------");


//        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
//            System.out.println(guestbookDTO);
//        }
        System.out.println(resultDTO);



//        System.out.println("========================================");
//        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}
