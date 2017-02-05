package DesignPatterns.StatePattern.Iterface;

/**
 * Created by Nikhil on 2/3/2017 12:54 PM.
 */
public interface ATMState {
    // Different states expected
    // HasCard, NoCard, HasPin, NoCash
    void insertCard();
    void ejectCard();
    void insertPin(int pinEntered);
    void requestCash(int cashToWithdraw);
}

