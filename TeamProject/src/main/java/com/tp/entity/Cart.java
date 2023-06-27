package com.tp.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int count; // 카트에 담긴 상품 개수

    @OneToOne(mappedBy = "cart", fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private UserEntity user;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Cart_item> cart_items = new ArrayList<>();

    
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	 private List<Cart_item> cart_item;
    
    
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate; // 날짜

    @PrePersist
    public void createDate(){
        this.createDate = LocalDate.now();
    }

    public static Cart createCart(UserEntity user){
        Cart cart = new Cart();
        cart.user = user;
        cart.count = 0;

        return cart;
    }
}


