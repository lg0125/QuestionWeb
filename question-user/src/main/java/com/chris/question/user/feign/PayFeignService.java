package com.chris.question.user.feign;

import com.chris.question.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("question-pay")
public interface PayFeignService {

    @GetMapping("/member/service/getting/{memberId}")
    R getMember(@PathVariable Long memberId);

    @GetMapping("/member/service/getting/{cardId}")
    R getCard(@PathVariable String cardId);


}
