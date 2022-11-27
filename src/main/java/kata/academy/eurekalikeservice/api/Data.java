package kata.academy.eurekalikeservice.api;

import lombok.Getter;

@Getter
public final class Data<T> {

    private final T data;

    private Data(T data) {
        this.data = data;
    }

    public static <T> Data<T> of(T data) {
        return new Data<>(data);
    }
}
