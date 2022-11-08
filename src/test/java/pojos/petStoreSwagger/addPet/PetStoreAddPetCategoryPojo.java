package pojos.petStoreSwagger.addPet;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(access = AccessLevel.PRIVATE)
public class PetStoreAddPetCategoryPojo {
    private int id;
    private String name;

}
