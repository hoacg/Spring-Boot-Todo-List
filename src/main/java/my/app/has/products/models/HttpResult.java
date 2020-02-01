package my.app.has.products.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class HttpResult<E> {
    private boolean success;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private E data;
}
