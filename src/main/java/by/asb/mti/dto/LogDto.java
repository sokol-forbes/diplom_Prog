package by.asb.mti.dto;

import by.asb.mti.dao.entity.User;
import lombok.*;

import java.util.Calendar;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LogDto {

    private Long id;
    private Calendar datetime;
    private String url;
    private String description;
    private User user;

}
