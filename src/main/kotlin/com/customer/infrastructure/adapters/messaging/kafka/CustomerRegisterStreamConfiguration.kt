package com.customer.infrastructure.adapters.messaging.kafka

import com.customer.infrastructure.adapters.executors.CustomerRegisterUseCaseExecutor
import com.customer.infrastructure.adapters.executors.dto.CustomerRegisterRequest
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Consumer


@Configuration
class CustomerRegisterStreamConfiguration(
    private val customerRegisterUseCaseExecutor: CustomerRegisterUseCaseExecutor
) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Bean
    fun customerRegisterStream(): Consumer<CustomerRegisterRequest> {
        return Consumer<CustomerRegisterRequest> {
            try {
                val customerRegisterResponse = customerRegisterUseCaseExecutor.execute(it)
                log.info("Customer created response={}", customerRegisterResponse)
            } catch (e: Throwable) {
                log.error("Customer created error", e)
            }
        }
    }
}