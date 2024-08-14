package com.example.commandcontrollermiddleware.services;

import org.springframework.ui.Model;

import java.io.IOException;

public interface ListFreeRoomsServiceInterface {
    void compileAndRunListAllFreeRooms(Model model) throws IOException, InterruptedException;
}
