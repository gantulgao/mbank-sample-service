package mn.mbank.sample.service.spec.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang.exception.ExceptionUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FinalResponse<T> {
    private String code;
    private String message;
    private T body;
    private String error;

    public void setError(Throwable err) {
        if (err != null) {
            this.error = ExceptionUtils.getStackTrace(err);
        }
    }

    public FinalResponse() {
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getBody() {
        return this.body;
    }

    public String getError() {
        return this.error;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setBody(final T body) {
        this.body = body;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FinalResponse;
    }

    public String toString() {
        return "FinalResponse(code=" + this.getCode() + ", message=" + this.getMessage() + ", body=" + this.getBody() + ", error=" + this.getError() + ")";
    }
}
