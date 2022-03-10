package com.emusicstore.dao.impl;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDaoImpl implements CartDao {

    private final Map<String,Cart> listOfCards;

    public CartDaoImpl(){
        listOfCards = new HashMap<String, Cart>();
    }

    public Cart create (Cart cart){
        if (listOfCards.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Cannot create a cart. A cart with given id(%) " +
                    "already" +
                    "exists",cart.getCartId()));
        }
        listOfCards.put(cart.getCartId(),cart);

        return cart;
    }

    public Cart read(String cartId){
        return listOfCards.get(cartId);
    }

    public void update(String cartId, Cart cart){
        if(!listOfCards.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Can not update cart. The cart with the given id(%) " +
                    "does not " + "exist",cart.getCartId()));
        }
        listOfCards.put(cartId,cart);
    }

    public void delete(String cartId){
        if(!listOfCards.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Can not delete cart. A cart with the given id(%) " +
                    "does not " +
                    "exist", cartId));
        }
        listOfCards.remove(cartId);
    }
}
