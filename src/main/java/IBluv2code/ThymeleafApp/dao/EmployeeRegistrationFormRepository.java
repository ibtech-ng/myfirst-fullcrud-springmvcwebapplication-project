package IBluv2code.ThymeleafApp.dao;

import IBluv2code.ThymeleafApp.form.EmployeeRegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRegistrationFormRepository extends JpaRepository <EmployeeRegistrationForm, Integer> {
    EmployeeRegistrationForm findByuserName(String userName);
}
