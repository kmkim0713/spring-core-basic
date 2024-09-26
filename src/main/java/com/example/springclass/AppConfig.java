package com.example.springclass;

import com.example.springclass.discount.DiscountPolicy;
import com.example.springclass.discount.FixDiscountPolicy;
import com.example.springclass.member.MemberService;
import com.example.springclass.member.MemberServiceImpl;
import com.example.springclass.member.MemoryMemberRepository;
import com.example.springclass.order.OrderService;
import com.example.springclass.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // IOC: 제어의 역전
    // spring container = DI container
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }

}
