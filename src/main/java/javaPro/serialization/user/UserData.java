package javaPro.serialization.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserData implements Serializable {

    private String login;
    private transient String password;
    private String email;
    @Serial
    private static final long serialVersionUID = 1L;
}
