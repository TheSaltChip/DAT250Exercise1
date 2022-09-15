package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bank", schema = "test")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owningBank", cascade = CascadeType.ALL)
    private Set<CreditCard> creditCards;

    public Long getId() {
        return id;
    }

    public Bank() {
        creditCards = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<CreditCard> getOwnedCards() {
        return creditCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public void addCreditCard(CreditCard creditCard){
        creditCards.add(creditCard);
    }
}
