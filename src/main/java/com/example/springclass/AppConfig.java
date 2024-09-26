package com.example.springclass;

import com.example.springclass.discount.FixDiscountPolicy;
import com.example.springclass.member.MemberService;
import com.example.springclass.member.MemberServiceImpl;
import com.example.springclass.member.MemoryMemberRepository;
import com.example.springclass.order.OrderService;
import com.example.springclass.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }


}
