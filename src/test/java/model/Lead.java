package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Model representing lead
 */
@Getter
@Setter
@Builder
public class Lead {
    private String id;
    private String firstName;
    private String lastName;

}
