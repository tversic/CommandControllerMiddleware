package com.example.commandcontrollermiddleware.services;

import org.springframework.ui.Model;

import java.io.IOException;

public interface CheckInServiceInterface {
    void compileAndRunCheckIn(String roomNumber, Model model) throws IOException, InterruptedException;

}
