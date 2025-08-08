package com.example.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.domain.Purchase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

// TODO-06: Annotate to this class to define it as a Spring bean.
// Select the most descriptive stereotype annotation.
@Repository
public class PurchaseDaoImpl implements PurchaseDao {

    //  TODO-07: Use the special JPA annotation to inject the EntityManager into this class.
    //  Hint: do NOT use @Autowired
    @PersistenceContext
    EntityManager em;
    @Override
    public List<Purchase> getAllPurchases() {
        String jpql = "SELECT p FROM Purchase p";
        return em
                .createQuery(
                        jpql,
                        Purchase.class)
                .getResultList();
    }

    @Override
    public Purchase getPurchase(int id) {
        return em.find(Purchase.class, id);
    }


    @Override
    public Purchase getPurchase(String name, Date date) {
        String jpql = "SELECT p FROM Purchase p WHERE p.customerName = :name AND p.purchaseDate = :date";
        return em
                .createQuery(jpql, Purchase.class)
                .setParameter("name", name)
                .setParameter("date", date)
                .getSingleResult();
    }


    @Override
    public void savePurchase(Purchase purchase) {
        if(purchase.getId() < 1) {
            em.persist(purchase);
        } else {
            em.merge(purchase);
        }
    }


}
