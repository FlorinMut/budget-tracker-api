package org.fasttrackit.budgettrackerapi.transfer.Expense;

import javax.validation.constraints.NotBlank;

public class AddExpense {

    @NotBlank
    private String name;
    private double amount;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AddExpense{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", quantity=" + quantity +
                '}';
    }
}
