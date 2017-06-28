package pl.edu.wat.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Hubert on 29.06.2017.
 */
@Getter
@Setter
public class OKResponseDto {

    Date date;
    String message;

    public OKResponseDto(Date date, String message) {
        this.date = date;
        this.message = message;
    }


}
