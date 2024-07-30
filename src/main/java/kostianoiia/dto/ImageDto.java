package kostianoiia.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@ToString
public class ImageDto {
    private String src;
    private String name;
    @JsonProperty("hOffset") // lombok формирует название геттера не так, как ожидает Jackson, поэтому добавляем аннотацию
    private int hOffset;
    @JsonProperty("vOffset")
    private int vOffset;
    private String alignment;
}
