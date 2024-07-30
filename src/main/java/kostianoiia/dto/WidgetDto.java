package kostianoiia.dto;

import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@ToString
public class WidgetDto {
    private String debug;
    private WindowDto window;
    private ImageDto image;
    private TextDto text;
}
