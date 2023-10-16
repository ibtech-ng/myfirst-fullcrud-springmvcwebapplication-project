package IBluv2code.ThymeleafApp.dao;

import IBluv2code.ThymeleafApp.form.StudentRegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRegistrationFormRepository extends JpaRepository<StudentRegistrationForm,Integer> {
    StudentRegistrationForm findByuserName(String useName);

    //
    //StudentRegistrationForm findByUsername(String userName);


}
