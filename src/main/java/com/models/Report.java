/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;


public class Report {
    
    private String period;
    private int sales;
    private int netProfit;
    private int noOfOrders;
    
    public Report(){
        
        
    }
    
    public Report(String period,int sales,int netProfit,int noOfOrders){
        
        
        
    }

    public boolean setPeriod(String period) {
        this.period = period;
        return true;
    }

    public boolean setSales(int sales) {
        this.sales = sales;
        return true;
    }

    public boolean setNetProfit(int netProfit) {
        this.netProfit = netProfit;
        return true;
    }

    public boolean setNoOfOrders(int noOfOrders) {
        this.noOfOrders = noOfOrders;
        return true;
    }

    public String getPeriod() {
        return period;
    }
    
    public boolean dispReport(){
        
        return true;
    }
    
    public boolean showSummary(){
        
        return true;
    }

    public int getSales() {
        return sales;
    }

    public int getNetProfit() {
        return netProfit;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }
    
    public void getSummary(){
        
        
    }
    
    public Report getSales(int period)
    {
        Report r=new Report();
        return r;
    }
}
