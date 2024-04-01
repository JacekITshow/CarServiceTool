package pl.itshow.java.repository;

import pl.itshow.java.dto.CustomerDto;

import java.util.List;

public interface CustomerDao {

    List<CustomerDto> findCustomersByGender(String gender);
}
