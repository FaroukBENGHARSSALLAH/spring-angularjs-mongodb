package com.farouk.bengarssallah.spring.angular.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farouk.bengarssallah.spring.angular.model.Option;
import com.farouk.bengarssallah.spring.angular.model.Portfolio;
import com.farouk.bengarssallah.spring.angular.model.Stock;
import com.farouk.bengarssallah.spring.angular.service.WalletService;

import org.springframework.http.MediaType;


@RestController
public class WalletRestController {


      @Autowired
     private WalletService walletService;
      
    
   
      @RequestMapping(value = "/reset", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
      public String reset() {
    	   clear();
	       int index = ThreadLocalRandom.current().nextInt(1, 7 + 1);
	       String rst = "<video class='embed-responsive-item'  autoplay='' controls='' ><source src='/vidulum/video/" + index + ".mp4' type='video/mp4'  ></video>";
           return  rst;
       }
      
      
    @RequestMapping(value = "/option/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Option> findOptions() {
        return walletService.findOptions();
    }
    
    @RequestMapping(value = "/option/buy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Option> buyOption(@RequestParam String optionReference, @RequestParam String portfolioReference) {
    	            Portfolio portfolio = walletService.findPortfolioByReference(portfolioReference);
			        Option option = walletService.findOptionByReference(optionReference);
			        option.setBuyer(portfolio.getOwner());
			        portfolio.getOptions().add(option);
			        walletService.updateOption(option);walletService.updatePortfolio(portfolio);
                    return walletService.findOptions();
    }
    
    @RequestMapping(value = "/portfolio/{reference}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Portfolio getPortfolio(@RequestParam  String portfolioReference) {
        return walletService.findPortfolioByReference(portfolioReference);
    }
    
    
    
	private void clear() {
							try {
								clearDatabase();
							} catch (SQLException e) {
								e.printStackTrace();
							}
					   Stock st = new Stock("APPL", 345L);
					   Stock st2 = new Stock("TSLA", 343L);
					   Stock st3 = new Stock("BRK.A", 333L);
				       Option opt = new Option("APL-CALL-67", 350L, "CALL", 4.10, new Date(), "", st);
				       Option opt2 = new Option("APL-PUT-34", 380L, "PUT", 8.10, new Date(), "", st);
				       Option opt3 = new Option("FB-CALL-42", 350L, "CALL", 5.10, new Date(), "", st2);
				       Option opt4 = new Option("FB-PUT-55", 380L, "PUT", 7.25, new Date(), "", st2);
				       Option opt5 = new Option("BRK-CALL-72", 350L, "CALL", 3.45, new Date(), "", st3);
				       Option opt6 = new Option("BRK-PUT-22", 380L, "PUT", 9.81, new Date(), "", st3);
				       Portfolio pt = new Portfolio("1", "Jim", new Date());
				       walletService.addStock(st);walletService.addStock(st2);walletService.addStock(st3);
				       walletService.addOption(opt);walletService.addOption(opt2);
				       walletService.addOption(opt3);walletService.addOption(opt4);
				       walletService.addOption(opt5);walletService.addOption(opt6);
				       walletService.addPortfolio(pt);
              }
    
    
    public void clearDatabase() throws SQLException {
					   for(Option option : walletService.findOptions()) {
						        walletService.deleteOption(option);
					   }
					   for(Stock stock : walletService.findAllStocks()) {
						        walletService.deleteStock(stock);
					   }
					   for(Portfolio portfolio : walletService.findAllPortfolios()) {
						        walletService.deletePorfolio(portfolio);
					   }
					}

            }


