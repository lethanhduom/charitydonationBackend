package com.management.charitydonation.Response;

import com.management.charitydonation.exception.ErrorCode;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateResponse {
String UPDATE_SUCCESS="update success";
String UPDATE_FAILED="update failed";
}
