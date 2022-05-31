package com.kodilla.good.patterns.challenges;

public class OrderInformationService {

    public boolean sendConfirmationEmail(User user) {
        if (user!=null) {
            System.out.println("Sending Confirmation Email");
            return true;
        } else {
            System.out.println("Sending rejection email");
            return false;
        }
    }
}
