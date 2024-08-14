package com.example.commandcontrollermiddleware.services;

import org.springframework.ui.Model;

import java.io.IOException;

public interface ChangeRoomDataServiceInterface {

    void compileAndRunChangeRoomData(String id, String name, String price, String checkedOut, String checkInDate, Model model) throws IOException, InterruptedException;
    String logProcessOutput(Process process) throws IOException, InterruptedException;
}
