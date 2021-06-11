package com.university.confectionary.controller;

import com.university.confectionary.domain.entities.OrderEntity;
import com.university.confectionary.dto.CreatedOrderDto;
import com.university.confectionary.dto.ResponseAdminDto;
import com.university.confectionary.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    public List<Integer> setTotalPage(Page page) {
        int totalPages = page.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(0, totalPages - 1)
                    .boxed()
                    .collect(Collectors.toList());
            return pageNumbers;
        }
        return List.of(0);
    }

    // get all orders by endpoint  /orders?size=6&page=2
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity<ResponseAdminDto> booksGet(@PageableDefault(size = 6) Pageable pageable) {
        Page<OrderEntity> page = orderService.findAllOrders(pageable);
        System.out.println("page");
        List<OrderEntity> list = page.toList();

        List<Integer> pageNumbers = setTotalPage(page);
        List<CreatedOrderDto> createdOrders = orderService.convertToDto(list);
        ResponseAdminDto responseAdminDto = ResponseAdminDto.builder()
                .pageNumbers(pageNumbers)
                .createdOrders(createdOrders)
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseAdminDto);
    }
}
