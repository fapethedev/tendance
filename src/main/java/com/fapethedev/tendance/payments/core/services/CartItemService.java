package com.fapethedev.tendance.payments.core.services;

import com.fapethedev.tendance.payments.core.repository.PackItemRepository;
import com.fapethedev.tendance.payments.core.repository.SubscriptionPlanItemRepository;
import com.fapethedev.tendance.payments.core.repository.TicketItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class CartItemService implements ICartItemService
{

    private PackItemRepository packItemRepository;


    private TicketItemRepository ticketItemRepository;

    private SubscriptionPlanItemRepository planItemRepository;

}
