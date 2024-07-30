package kostianoiia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@ToString
public class TextDto {
    private String data;
    private int size;
    private String style;
    private String name;
    @JsonProperty("hOffset")
    private int hOffset;
    @JsonProperty("vOffset")
    private int vOffset;
    private String alignment;
    private String onMouseUp;
}
