package com.example.studentmaneger.service;

import com.example.studentmaneger.entity.Student;
import com.example.studentmaneger.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // 1. Lấy tất cả sinh viên từ SQL Server
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // 2. Lấy sinh viên theo ID (Dùng cho chức năng Sửa/Xem chi tiết)
    public Optional<Student> getStudentById(int id) {
        return repository.findById(id);
    }

    // 3. Lưu hoặc Cập nhật sinh viên
    // JpaRepository tự hiểu: nếu đối tượng có ID đã tồn tại sẽ là Update, nếu ID mới sẽ là Insert
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    // 4. Xóa sinh viên theo ID
    public void deleteStudent(int id) {
        repository.deleteById(id);
    }

    // 5. Tìm kiếm sinh viên theo tên hoặc email (không phân biệt hoa thường)
    public List<Student> searchStudents(String keyword) {
        return repository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword);
    }
}