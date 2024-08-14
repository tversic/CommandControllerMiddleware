package com.example.commandcontrollermiddleware.services;

import org.springframework.ui.Model;

import java.io.IOException;

public interface CalculatePriceInterface {
    void compileAndRunCalculatePrice(String roomNumber, Model model) throws IOException, InterruptedException;

}
