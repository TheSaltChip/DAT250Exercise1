package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
@Table(name = "creditcard", schema = "test")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;
    private Integer limit;
    private Integer balance;

    @ManyToOne(targetEntity = Bank.class)
    @JoinColumn(referencedColumnName = "ID")
    private Bank owningBank;

    @OneToOne
    private Pincode pincode;

    public int getNumber() {
        return number;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getLimit() {
        return limit;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public Bank getOwningBank() {

        return owningBank;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setOwningBank(Bank owningBank) {
        this.owningBank = owningBank;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }
}
