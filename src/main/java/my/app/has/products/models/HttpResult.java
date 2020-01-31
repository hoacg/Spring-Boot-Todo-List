package my.app.has.products.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class HttpResult<E> {
    private boolean success;
    private String message;
    private E data;
}
