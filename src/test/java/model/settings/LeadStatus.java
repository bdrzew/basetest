package model.settings;

import lombok.Builder;
import lombok.Getter;

/**
 * Leads status model
 */
@Getter
@Builder
public class LeadStatus {
    private int index;
    private String name;
}
