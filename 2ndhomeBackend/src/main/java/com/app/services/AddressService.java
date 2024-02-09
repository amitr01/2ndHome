package com.app.services;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;

public interface AddressService {

	ApiResponse assignPropertyAdddress(@NotNull Long pid, @Valid AddressDTO address);

	AddressDTO getPropertyAddress(Long pid);

	ApiResponse updatePropertyAddress(@NotNull Long pid, @Valid AddressDTO address);

}
