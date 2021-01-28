package mn.mbank.sample.service.Exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY
)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"code", "desc"})
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
public class Error {
    @JsonProperty("code")
    String errcode;
    @JsonProperty("desc")
    String errdesc;
}