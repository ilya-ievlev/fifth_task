package org.profitsoft.fifth_task.dto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
public class RestResponse {

    private final String result;

    public RestResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
