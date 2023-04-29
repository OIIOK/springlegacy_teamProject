package com.friendly.eco.domain;

import lombok.Data;

@Data
//할까말까
public class FundingConsumerReward {
	private int funding_consumer_reward_idx;
	private Fconsumer fundingConsumer;
	private String funding_consumer_reward_name;
	private int funding_consumer_reward_quantity;
	private int funding_consumer_reward_amount;
}
