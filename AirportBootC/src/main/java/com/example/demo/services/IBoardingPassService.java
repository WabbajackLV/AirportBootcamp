package com.example.demo.services;

import java.util.Collection;

import com.example.demo.models.BoardingPass;
import com.example.demo.models.Flight;

public interface IBoardingPassService {

	Collection<BoardingPass> getAllBookingsByRUId(int id) throws Exception;

	Flight getFlightByBoardPassId(int id);

}
