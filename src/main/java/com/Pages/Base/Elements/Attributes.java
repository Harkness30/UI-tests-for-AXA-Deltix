package com.Pages.Base.Elements;

public enum Attributes {

    AVG_FILL_PRICE  ("Avg fill price"),
    EXEC_SIZE("Exec size"),
    NUM_OF_EXS("Num of executions"),
    PRICE("Price"),
    SIZE("Size"),
    EX_PRICE_VOLATILITY("Execution price volatility"),
    PERM_MARKET_IMPACT("Permanent market impact"),
    REALIZED_IMPACT("Realized market impact"),
    PART_RATE("Participation rate"),
    SHORTFALL("Shortfall"),
    MULTIPLIER("Multiplier"),
    TICK_SIZE("Tick size"),
    CURRENCY_CODE("Currency code"),
    SEQ_NUMBER("Sequence number"),
    DB_SEQ_NUMBER("Db sequence number"),
    BENCHMARK_PRICE("Benchmark price"),
    PRICE_IMP_TICKS("Price imp. (ticks)"),
    PRICE_IMP_AMOUNT("Price imp. (amount)");

    private String value;

    Attributes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
