package com.yeoff.jpopkaraokeserver.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@EnableAsync
@Configuration
class AsyncConfig {

    @Bean(name = ["asyncExecutor"])
    fun asyncExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()

        // 기본 유지 스레드 수
        executor.corePoolSize = 4

        // 최대 스레드 수
        executor.maxPoolSize = 16

        // 대기 큐 크기
        executor.queueCapacity = 100

        // 스레드 이름 prefix
        executor.setThreadNamePrefix("async-")

        // 종료 시 graceful shutdown
        executor.setWaitForTasksToCompleteOnShutdown(true)
        executor.setAwaitTerminationSeconds(30)

        executor.initialize()
        return executor
    }
}