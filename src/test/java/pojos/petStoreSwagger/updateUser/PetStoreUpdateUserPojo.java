package pojos.petStoreSwagger.updateUser;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(access = AccessLevel.PRIVATE)
public class PetStoreUpdateUserPojo {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;
}
