package com.example.commandcontrollermiddleware.services;

import org.springframework.ui.Model;

import java.io.IOException;

public interface CheckoutServiceInterface {
    void compileAndRunCheckOut(String roomNumber, Model model) throws IOException, InterruptedException;
}
