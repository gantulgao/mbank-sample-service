package mn.mbank.sample.service.Exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoreException extends RuntimeException {
    private Throwable err;
    private HttpStatus httpstat;
    private Error msgstat;

    public CoreException() {
    }

    public CoreException(String msg) {
        super(msg);
    }

    public CoreException(Throwable err) {
        this.err = err;
    }

    public Throwable err() {
        return this.err;
    }

    public HttpStatus httpstat() {
        return this.httpstat;
    }

    public Error msgstat() {
        return this.msgstat;
    }

    public CoreException err(final Throwable err) {
        this.err = err;
        return this;
    }

    public CoreException httpstat(final HttpStatus httpstat) {
        this.httpstat = httpstat;
        return this;
    }

    public CoreException msgstat(final Error msgstat) {
        this.msgstat = msgstat;
        return this;
    }

}