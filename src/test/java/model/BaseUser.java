package model;

import lombok.Builder;
import lombok.Data;

/**
 * BaseUser model class representing the base user
 */
@Data
@Builder
public class BaseUser {
    private String email;
    private String password;
}
