package com.example.commandcontrollermiddleware.services;

import org.springframework.ui.Model;

import java.io.IOException;

public interface ListAllCheckedinRoomsInfoInterface {
    void compileAndRunListAllCheckedinRooms(Model model) throws IOException, InterruptedException;

}
