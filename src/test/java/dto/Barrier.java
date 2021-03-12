package dto;

import java.time.LocalDateTime;

public class Barrier {
    protected long id;
    protected BarrierState state;
    protected long timestamp;
    protected LocalDateTime dateTime;
    protected int period;

    public Barrier() {
        super();
    }

    public Barrier(long id, BarrierState state, long timestamp, LocalDateTime dateTime, int period) {
        super();
        this.id = id;
        this.state = state;
        this.timestamp = timestamp;
        this.dateTime = dateTime;
        this.period = period;
    }

    public long getId() {
        return id;
    }

    public BarrierState getState() {
        return state;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getPeriod() {
        return period;
    }

    @Override
    public String toString() {
        return "Barrier [id=" + id + ", state=" + state + ", timestamp=" + timestamp + ", dateTime=" + dateTime
                + ", period=" + period + "]";
    }
}
