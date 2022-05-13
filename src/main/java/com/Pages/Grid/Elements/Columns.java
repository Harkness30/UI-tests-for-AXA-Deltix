package com.Pages.Grid.Elements;

public enum Columns {

    ID  ("orderId"),
    TYPE("orderType"),
    SIDE ("orderSide"),
    START_TIME("startTime"),
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

    Columns(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
