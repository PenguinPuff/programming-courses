package de.tum.cit.ase;
import java.util.LinkedList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class SealSaloon {
    private int totalOrders = 0;
    private static final Stock stock = new Stock();
    private Meal[] orders;

    public SealSaloon() {
        this.orders = new Meal[0]; // Initialize with an empty array
    }

    public static int calculateTotalPrice(Meal meal) {
        int totalPrice = 0;
        for (String ingredient : meal.getIngredients()) {
            StockIngredient stockIngredient = stock.findStockIngredient(ingredient);
            if (stockIngredient != null) {
                totalPrice += stockIngredient.getPrice();
            }
        }
        return totalPrice;
    }

    public static void acceptSupplyDelivery(String name, int price, int quantity) {
        StockIngredient ingredient = stock.findStockIngredient(name);
        if (ingredient == null) {
            stock.addToStockIngredients(new StockIngredient(name, price, quantity));
        } else {
            ingredient.addQuantity(quantity);
        }
    }

    public void orderMeal(Meal meal) {
        // Resize array to accommodate new order
        Meal[] newOrders = new Meal[orders.length + 1];
        System.arraycopy(orders, 0, newOrders, 0, orders.length);
        newOrders[orders.length] = meal;
        orders = newOrders;

        totalOrders++;
        checkOrderReady();
    }

    public void checkOrderReady() {
        List<Meal> remainingOrders = new ArrayList<>();
        for (Meal meal : orders) {
            boolean canPrepare = true;

            // Check if all ingredients are in stock
            for (String ingredient : meal.getIngredients()) {
                StockIngredient stockIngredient = stock.findStockIngredient(ingredient);
                if (stockIngredient == null || stockIngredient.getQuantity() <= 0) {
                    canPrepare = false;
                    break;
                }
            }

            if (canPrepare) {
                for (String ingredient : meal.getIngredients()) {
                    stock.take(ingredient);
                }
                System.out.println("The order is ready: " + meal.getName());
            } else {
                remainingOrders.add(meal);
            }
        }

        orders = remainingOrders.toArray(new Meal[0]);
    }

    public void calculateRemainingOrderNumber() {
        int remainingOrders = orders.length;
        int counter = 0;
        do {
            System.out.println("Order number: " + counter);
            counter++;
        } while (counter <= remainingOrders);
    }
}

