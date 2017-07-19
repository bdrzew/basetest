package model;

import lombok.Builder;
import lombok.Getter;

/**
 * Model representing lead
 */
@Getter
@Builder
public class Lead {
    private String firstName;
    private String lastName;

}
