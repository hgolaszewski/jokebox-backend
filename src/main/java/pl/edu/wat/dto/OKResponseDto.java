package pl.edu.wat.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Hubert on 29.06.2017.
 */
@Getter
@Setter
public class OKResponseDto {

    String message;

    public OKResponseDto() {
        this.message = "SUCCESS";
    }

}
