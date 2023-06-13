package com.example.springcashier;

 import java.text.DecimalFormat;
 import java.util.HashMap;
 import java.util.Map;
 import java.util.Random;
 import lombok.Data;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;


 @Entity
 @Data

class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id ;

    private String drink ;
    private String milk ;
    private String size ;
    private String total ;
    private String register ;
    private String status ;

  public static Order GetNewOrder() {
        String[] dirnk = { "Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino" };
        String[] mike = { "Whole", "2% Milk", "Almond Milk", "Oat Milk" };
        String[] size = {  "Tall", "Grande", "Venti" };

        Random ran = new Random();

        String ranDrink = dirnk[ran.nextInt(dirnk.length)];
        String ranMilk = mike[ran.nextInt(mike.length)];
        String ranSize = size[ran.nextInt(size.length)];

        Order cashierOrder = new Order();
        cashierOrder.setDrink(ranDrink);
        cashierOrder.setMilk(ranMilk);
        cashierOrder.setSize(ranSize);
        cashierOrder.setTotal(RandomOrder(ranDrink, ranSize));
        cashierOrder.setStatus("New");

        return cashierOrder;
    }

    private static String RandomOrder(String drink, String size) {
        Map<String, Map<String, Double>> prices = new HashMap<>();

        Map<String, Double> latte = new HashMap<>();
        latte.put("Tall", 2.95);
        latte.put("Grande", 3.65);
        latte.put("Venti", 3.95);
        prices.put("Caffe Latte", latte);

        Map<String, Double> americano = new HashMap<>();
        americano.put("Tall", 2.25);
        americano.put("Grande", 2.65);
        americano.put("Venti", 2.95);
        prices.put("Caffe Americano", americano);

        Map<String, Double> mocha = new HashMap<>();
        mocha.put("Tall", 3.45);
        mocha.put("Grande", 4.15);
        mocha.put("Venti", 4.45);
        prices.put("Caffe Mocha", mocha);

        Map<String, Double> cappuccino = new HashMap<>();
        cappuccino.put("Tall", 2.95);
        cappuccino.put("Grande", 3.65);
        cappuccino.put("Venti", 3.95);
        prices.put("Cappuccino", cappuccino);

        Map<String, Double> espresso = new HashMap<>();
        espresso.put("Short", 1.75);
        espresso.put("Tall", 1.95);
        prices.put("Espresso", espresso);

        double total = prices.get(drink).get(size);
        DecimalFormat printTotal = new DecimalFormat("#.##");
        return printTotal.format(total);

    }

}

/*

https://priceqube.com/menu-prices/%E2%98%95-starbucks

var DRINK_OPTIONS = [ "Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino" ];
var MILK_OPTIONS  = [ "Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk" ];
var SIZE_OPTIONS  = [ "Short", "Tall", "Grande", "Venti", "Your Own Cup" ];

Caffè Latte
=============
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Caffè Americano
===============
tall 	$2.25
grande 	$2.65
venti 	$2.95 (Your Own Cup)

Caffè Mocha
=============
tall 	$3.45
grande 	$4.15
venti 	$4.45 (Your Own Cup)

Cappuccino
==========
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Espresso
========
short 	$1.75
tall 	$1.95

 */







