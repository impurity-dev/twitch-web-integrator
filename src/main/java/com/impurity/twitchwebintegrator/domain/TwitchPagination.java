package com.impurity.twitchwebintegrator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author tmk2003
 */
@Data
public class TwitchPagination {
    @JsonProperty("cursor")
    private String cursor;
}
