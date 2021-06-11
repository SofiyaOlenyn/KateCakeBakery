package com.university.confectionary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseAdminDto {
    List<CreatedOrderDto> createdOrders;
    List<Integer> pageNumbers;
}
