package by.anastasya.medicalApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import by.anastasya.medicalApp.entity.Doctor;
import by.anastasya.medicalApp.entity.PlaceOfWork;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Doctor> getDoctorsBySpeciality(String speciality) {
        String sql = """
                SELECT doctors.doctor_id as doctor_id,
                            doctors.full_name as full_name,
                            doctors.category as category,
                            doctors.consult_price as consult_price,
                            doctors.speciality as speciality,
                            place_of_work.job_id as job_id,
                            place_of_work.job_name as job_name,
                            place_of_work.address as address,
                            place_of_work.is_policlinic as is_policlinic,
                            place_of_work.is_medical_center as is_medical_center
                            FROM doctors
                            JOIN place_of_work
                            ON
                            doctors.job_id=place_of_work.job_id
                            WHERE doctors.speciality=?
                """;


        List<Doctor> doctors = jdbcTemplate.query(sql,
                ps -> ps.setString(1, speciality),
                new DoctorMapper());

        return doctors;
    }

}

class DoctorMapper implements RowMapper<Doctor> {

    public Doctor mapRow(ResultSet rs, int arg1) throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(rs.getInt("DOCTOR_ID"));
        doctor.setFullName(rs.getString("FULL_NAME"));
        doctor.setSpeciality(rs.getString("SPECIALITY"));
        doctor.setCategory(rs.getString("CATEGORY"));
        doctor.setConsultPrice(rs.getInt("CONSULT_PRICE"));

        PlaceOfWork job = new PlaceOfWork();
        job.setJobId(rs.getInt("JOB_ID"));
        job.setJobName(rs.getString("JOB_NAME"));
        job.setAddress(rs.getString("ADDRESS"));
        job.setPoliclinic(rs.getBoolean("IS_POLICLINIC"));
        job.setMedicalCenter(rs.getBoolean("IS_MEDICAL_CENTER"));

        doctor.setPlaceOfWork(job);

        return doctor;
    }
}
