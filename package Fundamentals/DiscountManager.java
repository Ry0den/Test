package Kofi_Co_Fundamentals;

public class DiscountManager {
    private static DiscountManager instance;
    private boolean discountApplied = false;
    
    private DiscountManager() {}
    
    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }
    
    public void setDiscountApplied(boolean applied) {
        this.discountApplied = applied;
    }
    
    public boolean isDiscountApplied() {
        return discountApplied;
    }
    
    public double applyDiscount(double amount) {
        if (discountApplied) {
            return amount * 0.95; 
        }
        return amount;
    }
} 