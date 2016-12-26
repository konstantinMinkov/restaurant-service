package ua.kpi.integrations.restaurant.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RegistrationUserDto {

    @NotEmpty
    @Length(min = 3, max = 40)
    private String login;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Length(min = 6, max = 40)
    private String password;
}
