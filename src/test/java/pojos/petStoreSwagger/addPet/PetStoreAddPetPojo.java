package pojos.petStoreSwagger.addPet;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(access = AccessLevel.PRIVATE)
public class PetStoreAddPetPojo {

    private int id;
    private PetStoreAddPetCategoryPojo category;
    private String name;
    private List<String> photoUrls;
    private List<PetStoreAddPetTagsPojo> tags;
    private String status;


}
