package kostianoiia.dto;

import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@ToString
public class WindowDto {
    private String title;
    private String name;
    private int width;
    private int height;
}
