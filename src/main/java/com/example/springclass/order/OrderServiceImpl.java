package com.example.springclass.order;

import com.example.springclass.discount.DiscountPolicy;
import com.example.springclass.member.Member;
import com.example.springclass.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    // DIP를 지킨다
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
