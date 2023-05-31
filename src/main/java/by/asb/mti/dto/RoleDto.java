package by.asb.mti.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RoleDto {

    private Long id;

    private String authority;
}
