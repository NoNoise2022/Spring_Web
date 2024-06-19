package org.zerock.projectWeb.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.zerock.projectWeb.entity.Guestbook;
import org.zerock.projectWeb.entity.QGuestbook;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class GuestbookRepositoryTests {

    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i -> {
            Guestbook guestbook = Guestbook.builder()
                    .title("Title...." + i)
                    .content("Content..." + i)
                    .writer("user" + (i % 10))
                    .build();
            System.out.println(guestbookRepository.save(guestbook));
        });
    }

    @Test
    public void updateTest() {
        Optional<Guestbook> result = guestbookRepository.findById(300L); // Test with an existing ID

        if (result.isPresent()) {
            Guestbook guestbook = result.get();
            guestbook.changeTitle("Changed Title....");
            guestbook.changeContent("Changed Content...");

            guestbookRepository.save(guestbook);
        }
    }


    @Test
    public void testQuery1(){
//        PageRequest pageable = PageRequest.of(0,10, Sort.by("gno").descending());
        // Page request with sorting
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("gno").descending());

        // QueryDSL setup
        QGuestbook qGuestbook = QGuestbook.guestbook;
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        // Title contains "1"
        BooleanExpression expression = qGuestbook.title.contains("1");
        booleanBuilder.and(expression);

        // Fetch results
        Page<Guestbook> result = guestbookRepository.findAll(booleanBuilder, pageable);
        result.forEach(guestbook -> {
            System.out.println(guestbook);
        });
    }


    @Test
    public void testQuery2(){
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("gno").descending());
        QGuestbook qGuestbook = QGuestbook.guestbook;
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        BooleanExpression expression = qGuestbook.title.contains("1");
        BooleanExpression exAll = expression.or(qGuestbook.content.contains("1"));

        booleanBuilder.and(exAll);
        booleanBuilder.and(qGuestbook.gno.gt(0L));
        // Fetch results
        Page<Guestbook> result = guestbookRepository.findAll(booleanBuilder, pageable);
        result.forEach(guestbook -> {
            System.out.println(guestbook);
        });
    }
}
