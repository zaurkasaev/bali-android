package com.android.bali.models;

/**
 * Created by zaur_ on 14-Nov-17.
 */

public class Data {
    private String buttonURL;

    private String mainURL;

    private Categories categories;

    private Tickets tickets;

    private String buttonText;

    public String getButtonURL() {
        return buttonURL;
    }

    public void setButtonURL(String buttonURL) {
        this.buttonURL = buttonURL;
    }

    public String getMainURL() {
        return mainURL;
    }

    public void setMainURL(String mainURL) {
        this.mainURL = mainURL;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Tickets getTickets() {
        return tickets;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    @Override
    public String toString() {
        return "ClassData [buttonURL = " + buttonURL + ", mainURL = " + mainURL + ", categories = " + categories + ", tickets = " + tickets + ", buttonText = " + buttonText + "]";
    }
}
