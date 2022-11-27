package com.adrynov.benchmarking.components;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstration of Micrometer metrics
 * <p>
 * <a href="https://prometheus.io/docs/practices/instrumentation/#counter-vs-gauge-summary-vs-histogram">Counter vs Gauge</a>
 */
//@Component
public class Scheduler {
    private final AtomicInteger testGauge;
    private final Counter testCounter;

    public Scheduler(MeterRegistry meterRegistry) {
        testGauge = meterRegistry.gauge("custom_gauge", new AtomicInteger(0));
        testCounter = meterRegistry.counter("custom_counter");
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Scheduled(fixedRateString = "1000", initialDelay = 0)
    public void schedulingTask() {
        testGauge.set(Scheduler.getRandomNumberInRange(0, 100));
        testCounter.increment();
    }
}
