package pl.edu.wat.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pl.edu.wat.domain.Category;

import java.io.Serializable;

/**
 * Created by Hubert on 25.06.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleCategoryDto implements Serializable, Comparable {

    int id;
    String name;
    String requestparam;

    public SimpleCategoryDto(Category category){
        this.id = category.getId();
        this.name = category.getName();
        this.requestparam = category.getRequestparam();
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((SimpleCategoryDto)o).getName());
    }

}
