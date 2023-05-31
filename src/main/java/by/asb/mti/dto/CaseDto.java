package by.asb.mti.dto;

import by.asb.mti.dto.info.MtN92Dto;
import by.asb.mti.dto.info.MtN95Dto;
import by.asb.mti.dto.info.MtN96Dto;
import by.asb.mti.dto.info.MtN99Dto;
import by.asb.mti.dto.money.*;
import lombok.*;

import java.util.Calendar;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CaseDto {
    private Long id;
    private String reference;
    private Calendar datetimeOpen;
    private Calendar datetimeClose;
    private Boolean status;
    private UserDto userOpen;
    private UserDto userClose;
    //money message
    private Mt103Dto mt103;
    private Mt200Dto mt200;
    private Mt202Dto mt202;
    private Mt202COVDto mt202COV;
    private Mt900Dto mt900;
    private Mt910Dto mt910;
    //text message
    private List<MtN92Dto> mtN92List;
    private List<MtN95Dto> mtN95List;
    private List<MtN96Dto> mtN96List;
    private List<MtN99Dto> mtN99List;

}
