package com.curdoperations.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {

    public String message;
    public boolean success;
}
