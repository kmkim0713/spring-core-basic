package com.example.springclass;

import com.example.springclass.member.Grade;
import com.example.springclass.member.Member;
import com.example.springclass.member.MemberService;
import com.example.springclass.member.MemberServiceImpl;
import com.example.springclass.order.Order;
import com.example.springclass.order.OrderService;
import com.example.springclass.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }

}

