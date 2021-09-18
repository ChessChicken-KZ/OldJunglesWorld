package kz.chesschicken.ojw.utils;

import java.util.Objects;

public class BiValue<T, K> {

    private T value_t;
    private K value_k;

    public BiValue(T t, K k) {
        this.value_t = t;
        this.value_k = k;
    }

    public BiValue() {
    }

    public void set_first(T t) {
        this.value_t = t;
    }

    public void set_second(K k) {
        this.value_k = k;
    }

    public T get_first() {
        return this.value_t;
    }

    public K get_second() {
        return this.value_k;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        BiValue<?, ?> that = (BiValue<?, ?>) o;
        return Objects.equals(value_t, that.value_t) && Objects.equals(value_k, that.value_k);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value_t, value_k);
    }
}
