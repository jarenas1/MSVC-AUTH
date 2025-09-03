package co.com.pragma.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UserRegistrationReq(
        String firstName,
        String lastName,
        LocalDate birthDate,
        String address,
        String phone,
        String identificationNumber,
        String email,
        BigDecimal baseSalary
) {
}
