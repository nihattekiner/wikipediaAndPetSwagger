package pojos.petStoreSwagger.createUser;

import lombok.*;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(access = AccessLevel.PRIVATE)
public class PetStoreCreateUserPojo {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;
}
