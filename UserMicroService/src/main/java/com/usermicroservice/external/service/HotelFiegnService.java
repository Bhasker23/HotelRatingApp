package com.usermicroservice.external.service;

import com.usermicroservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelFiegnService {

    @GetMapping("/hotel/getHotel/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
