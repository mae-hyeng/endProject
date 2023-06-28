package com.tp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class OrderItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Order_item_id

	@Column
    private int count; // 개수

	@Column
    private int price; // 금액

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private MenuOrder order; // 주문 연결

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drink_id")
    private Menu menu; // 아이템 연결

    public static OrderItem createOrderItem(Menu menu, int count){

    	OrderItem orderitem = new OrderItem();
    	orderitem.setMenu(menu);
    	orderitem.setCount(count);
    	orderitem.setPrice(menu.getPrice());

        return orderitem;
    }

}
