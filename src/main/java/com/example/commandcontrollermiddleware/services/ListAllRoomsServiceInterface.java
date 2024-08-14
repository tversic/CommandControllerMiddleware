package com.example.commandcontrollermiddleware.services;

import org.springframework.ui.Model;

import java.io.IOException;

public interface ListAllRoomsServiceInterface {
    void compileAndRunListAllRooms(Model model) throws IOException, InterruptedException;

}
