package com.example.commandcontrollermiddleware.controllers;

import com.example.commandcontrollermiddleware.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CommandController {

    @Autowired
    ChangeRoomDataServiceInterface changeRoomDataServiceInterface;
    @Autowired
    CheckInServiceInterface checkInServiceInterface;
    @Autowired
    CheckoutServiceInterface checkoutServiceInterface;
    @Autowired
    CalculatePriceInterface calculatePriceInterface;
    @Autowired
    ListAllRoomsServiceInterface listAllRoomsServiceInterface;
    @Autowired
    ListAllCheckedinRoomsInfoInterface listAllCheckedinRoomsInfoInterface;
    @Autowired
    ListFreeRoomsServiceInterface listFreeRoomsServiceInterface;

    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }
    @GetMapping("/changeromdata")
    public String showChangeRoomData() {
        return "changeromdata";
    }

    @GetMapping("/checkin")
    public String showCheckin() {
        return "checkin";
    }

    @GetMapping("/checkout")
    public String showCheckout() {
        return "checkout";
    }

    @GetMapping("/listcheckedinrooms")
    public String showAllCheckedInRooms() {
        return "listallcheckedinrooms";
    }

    @GetMapping("/listallrooms")
    public String showListAllRooms() {
        return "listallrooms";
    }
    @GetMapping("/calculateprice")
    public String showCalculatePrice() {
        return "calculateprice";
    }
    @GetMapping("/listfreerooms")
    public String showListFreeRooms() {
        return "listfreerooms";
    }

    @PostMapping("/executeChangeRoomData")
    public String executeChangeRoomData(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "price", required = false) String price,
            @RequestParam(value = "checkedOut", required = false) String checkedOut,
            @RequestParam(value = "checkInDate", required = false) String checkInDate,
            Model model) {

        try {
            changeRoomDataServiceInterface.compileAndRunChangeRoomData(id, name, price, checkedOut, checkInDate, model);
        } catch (Exception e) {
            model.addAttribute("result", "Error executing command: " + e.getMessage());
        }
        return "result";
    }

    @PostMapping("/checkin")
    public String executeCheckIn(
            @RequestParam(value = "roomNumber", required = true) String roomNumber,
            Model model) {

        try {
            checkInServiceInterface.compileAndRunCheckIn(roomNumber, model);
        } catch (Exception e) {
            model.addAttribute("result", "Error executing command: " + e.getMessage());
        }
        return "result";
    }

    @PostMapping("/checkout")
    public String executeCheckOut(
            @RequestParam(value = "roomNumber", required = true) String roomNumber,
            Model model) {

        try {
            checkoutServiceInterface.compileAndRunCheckOut(roomNumber, model);
        } catch (Exception e) {
            model.addAttribute("result", "Error executing command: " + e.getMessage());
        }
        return "result";
    }

    @PostMapping("/calculateprice")
    public String executeCalculatePrice(
            @RequestParam(value = "roomNumber", required = true) String roomNumber,
            Model model) {

        try {
            calculatePriceInterface.compileAndRunCalculatePrice(roomNumber, model);
        } catch (Exception e) {
            model.addAttribute("result", "Error executing command: " + e.getMessage());
        }
        return "result";
    }

    @PostMapping("/listallrooms")
    public String executeListAllRooms(Model model) {

        try {
            listAllRoomsServiceInterface.compileAndRunListAllRooms(model);
        } catch (Exception e) {
            model.addAttribute("result", "Error executing command: " + e.getMessage());
        }
        return "result";
    }

    @PostMapping("/listallcheckedinrooms")
    public String executeListAllCheckedinRooms(Model model) {

        try {
            listAllCheckedinRoomsInfoInterface.compileAndRunListAllCheckedinRooms(model);
        } catch (Exception e) {
            model.addAttribute("result", "Error executing command: " + e.getMessage());
        }
        return "result";
    }

    @PostMapping("/listfreerooms")
    public String executeListFreeRooms(Model model) {

        try {
            listFreeRoomsServiceInterface.compileAndRunListAllFreeRooms(model);
        } catch (Exception e) {
            model.addAttribute("result", "Error executing command: " + e.getMessage());
        }
        return "result";
    }

}
