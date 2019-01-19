package com.farouk.bengarssallah.spring.angular.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farouk.bengarssallah.spring.angular.model.Option;
import com.farouk.bengarssallah.spring.angular.model.Portfolio;
import com.farouk.bengarssallah.spring.angular.model.Stock;
import com.farouk.bengarssallah.spring.angular.repository.OptionRepository;
import com.farouk.bengarssallah.spring.angular.repository.PortfolioRepository;
import com.farouk.bengarssallah.spring.angular.repository.StockRepository;



@Service
@Transactional
public class WalletService {

    @Autowired
    StockRepository stockRepository;
    
    @Autowired
    OptionRepository optionRepository;
    
    @Autowired
    PortfolioRepository portfolioRepository;

   
    
    public List<Option> findOptions() {
    	List<Option> list = optionRepository.findAll();
    	List<Option> options = new ArrayList<>();
    	for(Option option : list){
    		        if(option.getBuyer().equals("")) options.add(option);
    	          }
    	return options;
    }
    
    public List<Option> findAllOptions() {
    	return  optionRepository.findAll();
    }
    
    public List<Stock> findAllStocks() {
    	return  stockRepository.findAll();
    }
    
    public List<Portfolio> findAllPortfolios() {
    	return  portfolioRepository.findAll();
    }
    
    public Portfolio findPortfolioByReference(String reference) {
        return portfolioRepository.findByReference(reference);
    }
    
    public Option findOptionByReference(String reference) {
        return optionRepository.findByReference(reference);
    }
    
    public Stock findBySymbol(String symbol) {
        return stockRepository.findBySymbol(symbol);
    }
    
    public void addPortfolio(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }
    
    
    public void addOption(Option option) {
        optionRepository.save(option);
    }
    
    
    public void addStock(Stock stock) {
        stockRepository.save(stock);
    }
    
    public void updatePortfolio(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }
    
    public void updateOption(Option option) {
    	optionRepository.save(option);
    }
    
    
    public void deleteOption(Option option) {
    	optionRepository.delete(option);
    }
    
    
    public void deleteStock(Stock stock) {
    	stockRepository.delete(stock);
    }
    
    public void deletePorfolio(Portfolio portfolio) {
    	portfolioRepository.delete(portfolio);
    }
    
    
    public void buyOption(String portfolioReference, String optionReference) {
                    Portfolio portfolio =  portfolioRepository.findByReference(portfolioReference);
                    Option option =  optionRepository.findByReference(optionReference);
                    portfolio.getOptions().add(option);
                    portfolioRepository.save(portfolio);
    }
    
}
