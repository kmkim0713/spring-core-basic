package com.example.springclass.order;

import com.example.springclass.discount.DiscountPolicy;
import com.example.springclass.discount.FixDiscountPolicy;
import com.example.springclass.member.Member;
import com.example.springclass.member.MemberRepository;
import com.example.springclass.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
