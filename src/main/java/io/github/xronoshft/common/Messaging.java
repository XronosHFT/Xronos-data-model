package io.github.xronoshft.common;

public interface Messaging {

  enum Topic {

    /**
     * Topic name: to/from trading-engine.
     */
    GATEWAY(1),

    /**
     * Topic name: to/from trading-engine.
     */
    APPLICATION(1),

    /**
     * Topic name: to/from trading-engine.
     */
    STRATEGY(1),

    /**
     * Topic name: events to trading-engine.
     */
    TRADE(1),

    /**
     * Topic name: events to storage-engine.
     */
    STORAGE(1),

    /**
     * Topic name: events to storage-engine.
     */
    DATA(1),

    /**
     * Topic name: events to back-test engine.
     */
    BACK_TEST(1),

    /**
     * redis in channel
     */
    IN_CHANNEL(1),


    /**
     * redis in channel
     */
    OUT_CHANNEL(1),

    ;

    private final int concurrency;

    Topic(int concurrency) {
      this.concurrency = concurrency;
    }

    public int getConcurrency() {
      return this.concurrency;
    }

    public int getPartitions() {
      return this.concurrency;
    }
  }
}
