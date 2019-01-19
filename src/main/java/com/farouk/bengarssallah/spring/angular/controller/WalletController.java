package com.farouk.bengarssallah.spring.angular.controller;

import com.farouk.bengarssallah.spring.angular.service.WalletService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class WalletController {


      @Autowired
      WalletService walletService;

      @RequestMapping(value = "/")
  	public String getHome(Model model) {
  		               return "home";
  	                     }
      
    
}


